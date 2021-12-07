package com.everi.stepdefinitions;

import com.everi.exception.AutomationException;
import com.everi.pages.Application_Information;
import io.cucumber.java.en.And;

import java.io.IOException;


public class Applicationsteps {
	

	Application_Information applninfo= new Application_Information() ;

	@And("Fill application page information")
	public void fill_landing_page_information() throws AutomationException, IOException, InterruptedException  {
		applninfo.applicationpage();
		applninfo.access_request_type_dropdown();
		applninfo.access_applicationType();
		applninfo.select_arrival_date();
		applninfo.select_trip_occassion();
		applninfo.select_credit_limit();
		applninfo.enter_the_card_number();
		applninfo.enter_the_referred_by_host();
		applninfo.select_other_casino_credit();
		applninfo.click_on_next_button();
		applninfo.personal_information_tab_should_display();
	}

}
