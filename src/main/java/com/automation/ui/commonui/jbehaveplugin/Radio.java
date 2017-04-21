package com.automation.ui.commonui.jbehaveplugin;

public class Radio {
	
	boolean switchOnOff = false;

	public void switchOnOff() {
		switchOnOff = !switchOnOff;
	}

	public boolean isTurnedOn() {
		return switchOnOff;
	}

}
