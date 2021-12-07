package com.everi.stepdefinitions;

import com.everi.exception.AutomationException;
import com.everi.pages.Landing_page;
import io.cucumber.java.en.Given;

import java.io.IOException;


public class Landingpage_steps {
	
	public Landingpage_steps() {
	
		land=new Landing_page();
		
	}
	

	Landing_page land;
		
	
    @Given("^Fill Landing page information$")
	public void fill_landing_page_information() throws AutomationException, IOException {

		land.enter_accept();
		land.next_button();
		land.dashboard_screen_should_display();
		
	}
	
	
}