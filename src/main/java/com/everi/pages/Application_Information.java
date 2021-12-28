package com.everi.pages;

import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.helper.Webutility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Application_Information   {

	String request_type_dropDown;
	String application_type_dropDown;
	String trip_occassion_dropDown;
	String arrival_date;
	String credit_limit;
	String card_number;
	String referred_by_host;
	String other_casino_credit_dropDown;
	String casino_name;
	String casino_limit;
	String casino_state;
	String next_button;
	String Personal_information_tile;



	public Application_Information() {

		request_type_dropDown="//*[@id=\"mat-select-0\"]/div/div[1]/span";
		application_type_dropDown="//*[@id=\"mat-select-1\"]/div/div[1]/span";
		trip_occassion_dropDown="//*[@id=\"mat-select-2\"]/div/div[1]/span";
		arrival_date="//*[@id=\"mat-input-1\"]";
		credit_limit="//*[@id=\"mat-input-2\"]";
		card_number="//input[@id='mat-input-3']";
		referred_by_host="//input[@id='mat-input-4']";
		other_casino_credit_dropDown="//*[@id=\"mat-select-3\"]/div/div[1]/span";
		casino_name="//input[@placeholder='Casino Name']";
		casino_limit="//input[@placeholder='Credit Limit']";
		casino_state="//span[@class='mat-select-placeholder ng-tns-c14-94 ng-star-inserted']";		              
		next_button="//*[@id=\"wizardProfile\"]/div[2]/div/div/div/button";
		Personal_information_tile="//h5[contains(text(),'Personal Details')]";

	}


	//Driverutility driverutil=new Driverutility();
	Webutility webutil=new Webutility();
	DriverHelper driver=new DriverHelper(GlobalVariables.webDriver);

	public void applicationpage() {

		System.out.println("application page is displayed");
	}
	
	public void access_request_type_dropdown() throws AutomationException,InterruptedException {
		By by=By.xpath(request_type_dropDown);
		driver.waitUntilElementPresent(by,30);
		WebElement element=driver.getwebElement(request_type_dropDown, LocatorType.XPATH);
		driver.click(element);
		String text= GlobalVariables.testDataMap.get("RequestType");
		webutil.selectTextInDropDown(text);


	}

	public void access_applicationType() throws AutomationException, InterruptedException {
		By by=By.xpath(application_type_dropDown);
		driver.waitUntilElementPresent(by,30);
		WebElement element=driver.getwebElement(application_type_dropDown, LocatorType.XPATH);
		driver.click(element);
		String text= GlobalVariables.testDataMap.get("ApplicationType");
		Thread.sleep(5000);
		webutil.selectTextInDropDown(text);

	}

	public void select_arrival_date()throws AutomationException, IOException {
		WebElement element=driver.getwebElement(arrival_date, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("ArrivalDate"));

	}

	public void select_trip_occassion() throws AutomationException,InterruptedException{
		WebElement element=driver.getwebElement(trip_occassion_dropDown, LocatorType.XPATH);
		driver.click(element);
		String text= GlobalVariables.testDataMap.get("TripOccassion");
		webutil.selectTextInDropDown(text);

	}

	public void select_credit_limit() throws AutomationException, IOException {
		WebElement element=driver.getwebElement(credit_limit, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("CreditLimit"));
	}


	public void enter_the_card_number()throws AutomationException, IOException {
		WebElement element=driver.getwebElement(card_number, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("Cardnumber"));
	}

	public void enter_the_referred_by_host() throws AutomationException, IOException {
		WebElement element=driver.getwebElement(referred_by_host, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("ReferredByHost"));

	}


	public void select_other_casino_credit() throws AutomationException, IOException,InterruptedException{
		WebElement element=driver.getwebElement(other_casino_credit_dropDown, LocatorType.XPATH);
		driver.click(element);
		String text= GlobalVariables.testDataMap.get("OtherCasinoCredit");

		switch(text) {
		case "Yes" :
			webutil.selectTextInDropDown(text);
			enter_casino_name();
			enter_casino_limit();
			enter_casino_state();
			break;
		case "No":   
			webutil.selectTextInDropDown(text);
			break;
		}

	}

	public void enter_casino_name() throws AutomationException, IOException{
		WebElement element=driver.getwebElement(casino_name, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("Casinoname"));

	}

	public void enter_casino_limit() throws AutomationException, IOException {
		WebElement element=driver.getwebElement(casino_limit, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("Casinocreditlimit"));

	}

	public void enter_casino_state()throws AutomationException,InterruptedException{
		WebElement element=driver.getwebElement(casino_state, LocatorType.XPATH);
		driver.click(element);
		String text= GlobalVariables.testDataMap.get("CasinoState");
		webutil.selectTextInDropDown(text);

	}


	public void click_on_next_button()throws AutomationException {
		WebElement element=driver.getwebElement(next_button, LocatorType.XPATH);
		driver.click(element);

	}

	public void personal_information_tab_should_display() {
		By by=By.xpath(Personal_information_tile);
		driver.waitUntilElementPresent(by,30);
		String Expectedresult="Personal Details";
		WebElement element= driver.getwebElement(Personal_information_tile,LocatorType.XPATH);
		String title=driver.gettext(element);
		webutil.verify(Expectedresult,title);
	}

}

