package com.automation.ui.commonui.jbehaveplugin;

<<<<<<< HEAD
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
=======
import static org.testng.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
>>>>>>> 9b43c1e5e74f387b2f9fd8230eb2c778fe801a1a

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
<<<<<<< HEAD
		Assert.assertTrue(radio.isTurnedOn());
=======
		assertTrue(radio.isTurnedOn());
>>>>>>> 9b43c1e5e74f387b2f9fd8230eb2c778fe801a1a
	}

}
