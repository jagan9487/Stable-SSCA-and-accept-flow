package com.everi.stepdefinitions;

import com.everi.exception.AutomationException;
import com.everi.pages.Financial_Information;
import io.cucumber.java.en.And;

import java.io.IOException;


public class Financial_info_steps {

	Financial_Information financialinfo = new Financial_Information();


	@And("Fill financial page information")
	public void fill_financial_page_information() throws AutomationException, IOException, InterruptedException {

		financialinfo.financialpage();
		financialinfo.enter_estimatedtotalnetworth();
		financialinfo.enter_estimatedtotaldebt();
		financialinfo.click_on_next_button();
		financialinfo.disclosure_tab_should_display();

	}
}
