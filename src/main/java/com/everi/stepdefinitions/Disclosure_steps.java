package com.everi.stepdefinitions;

import com.everi.exception.AutomationException;
import com.everi.pages.Disclosure;
import io.cucumber.java.en.And;

import java.io.IOException;

public class Disclosure_steps {

	
	
	Disclosure disclosure= new Disclosure() ;



	@And("Fill disclosure page information")
	public void fill_disclosure_page_information() throws AutomationException, IOException, InterruptedException {

		disclosure.disclosurepage();
		disclosure.click_privacypolicies();
		disclosure.signature();
		disclosure.submit();
		disclosure.getApplicationId();
		
	}

}
