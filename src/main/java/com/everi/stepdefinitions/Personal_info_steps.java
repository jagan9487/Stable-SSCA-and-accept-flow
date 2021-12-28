package com.everi.stepdefinitions;

import com.everi.exception.AutomationException;
import com.everi.pages.Personal_Information;
import io.cucumber.java.en.And;

import java.io.IOException;

public class Personal_info_steps {
	
	Personal_Information personalinfo= new Personal_Information();

	@And("Fill personal page information")
	public void fill_personal_page_information() throws AutomationException, IOException, InterruptedException  {
		personalinfo.personalpage();
		personalinfo.enter_firstname();
		personalinfo.enter_lastname();
		personalinfo.enter_akafirstname();
		personalinfo.enter_akalastname();
		personalinfo.enter_dob();
		personalinfo.enter_Mothersmaidenname();
		personalinfo.select_patrongender();
		personalinfo.select_maritalstatus();
		personalinfo.address(1);
		personalinfo.address1(2);
		personalinfo.address2(3);
		personalinfo.select_primayphonetype();
		personalinfo.select_primaryphone();
		personalinfo.enter_patronemail();
		personalinfo.enter_preferredcontactmethod();
		personalinfo.enter_patronidentification();
		personalinfo.select_typeofidentification();
		personalinfo.select_passportnumber();
		personalinfo.select_passportissuingccountry();
		personalinfo.enter_idexpirydate();
		personalinfo.click_nextbutton();
		personalinfo.financial_information_tab_should_display();
	}

}




