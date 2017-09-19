package net.serenity.bdd.junit.cucumber.steps;

import java.io.IOException;
import java.net.MalformedURLException;

import net.serenity.bdd.junit.cucumber.model.CheckStatusData;
import net.serenity.bdd.junit.cucumber.pages.CheckStatusPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckStatusTestSteps extends ScenarioSteps {
	
	CheckStatusPage CSP;
	
	@Step
	public void openIRS2Go() throws MalformedURLException {
		CSP.openIRS2Go_PO();
	}
	
	@Step
	public void performLogin(CheckStatusData dp) throws InterruptedException {
		CSP.performLogin_PO(dp);
	}
	
	@Step
	public void isRefundStatusPresent() {
		CSP.isRefundStatusPresent_PO();
	}

}
