package net.serenity.bdd.junit.cucumber.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import net.serenity.bdd.junit.cucumber.model.CheckStatusData;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CheckStatusPage extends GenericPageObject {
	
	AndroidDriver driver;
	
	public void openIRS2Go_PO() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "SAMSUNG-SM-G920V");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appActivity", "gov.irs.irs2go.activity.IRS2GoActivity");          
		caps.setCapability("appPackage", "gov.irs");                                          
		caps.setCapability("udid", "0316032092572804");
		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void performLogin_PO(CheckStatusData dp) {

		driver.findElementById("gov.irs:id/taxId3Edit").sendKeys(dp.getSSN1());
		driver.findElementById("gov.irs:id/taxId2Edit").sendKeys(dp.getSSN2());
		driver.findElementById("gov.irs:id/taxId4Edit").sendKeys(dp.getSSN3());
		
		driver.findElementById("gov.irs:id/refundAmountEdit").sendKeys(dp.getRefundAmount());
		
		driver.findElementById("gov.irs:id/filingStatusSpinner").click();  
		
		List<WebElement> statuses = driver.findElementsById("android:id/text1");
		
		for (WebElement status : statuses) {
			if(status.getText().contains(dp.getFilingStatus())) {
				status.click();
				break;
			}
		}
		
//		driver.findElementById("gov.irs:id/getStatusButton").click();
		
		
		
	}

	public void isRefundStatusPresent_PO() {
		
		WebElement refundStatus = driver.findElementById("gov.irs:id/titleRefund");
		Assert.assertEquals(refundStatus.getText(), "Refund Status");
		
		driver.quit();
	}

}
