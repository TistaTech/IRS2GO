package net.serenity.bdd.junit.cucumber.stepDef;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenity.bdd.junit.cucumber.model.CheckStatusData;
import net.serenity.bdd.junit.cucumber.steps.CheckStatusTestSteps;
import net.thucydides.core.annotations.Steps;

public class CheckStatusTestStepDef extends GenericDeclarationClass {
	
	CheckStatusData dp = new CheckStatusData();
	
	@Steps
	CheckStatusTestSteps CS_steps;
	
	@Given("^I use valid \"([^\"]*)\", valid \"([^\"]*)\", valid \"([^\"]*)\"$")
	public void i_use_valid_valid_valid(String SSN, String filingStatus, String refundAmount) {
	    dp.setAll(SSN, filingStatus, refundAmount);
	}

	@When("^I input my inforamtion in IRS(\\d+)Go$")
	public void i_input_my_inforamtion_in_IRS_Go(int arg1) throws InterruptedException, IOException {
		CS_steps.openIRS2Go();
	    CS_steps.performLogin(dp);
	}

	@Then("^I should be able to check the status of the (\\d+) Tax Return$")
	public void i_should_be_able_to_check_the_status_of_the_Tax_Return(int arg1) {
	    CS_steps.isRefundStatusPresent();
	}
}
