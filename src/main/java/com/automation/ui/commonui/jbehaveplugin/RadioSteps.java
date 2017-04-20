package com.automation.ui.commonui.jbehaveplugin;

import static org.testng.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RadioSteps {

	private Radio radio;

	@Given("a digital radio")
	public void aDigitalRadio() {
		radio = new Radio();
	}

	@When("i turn on the radio")
	public void iTurnOnTheRadio() {
		radio.switchOnOff();
	}

	@Then("the radio should be turned on")
	public void theRadioShouldBeTurnedOn() {
		assertTrue(radio.isTurnedOn());
	}

}
