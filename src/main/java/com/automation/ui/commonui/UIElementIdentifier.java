package com.automation.ui.commonui;

import com.automation.ui.commonui.UIElement.SearchBy;

public class UIElementIdentifier {
	
	private String	 elementIden = null;
	
	private SearchBy idenType	 = null;
	
	public UIElementIdentifier(String elementIdentifier, SearchBy identifierType) {
		
		elementIden = elementIdentifier;
		
		idenType = identifierType;
	}
	
	public String getElementString() {
		return elementIden;
	}
	
	public SearchBy getElementIndenType() {
		return idenType;
	}
	
}
