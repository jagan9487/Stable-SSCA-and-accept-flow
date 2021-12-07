package com.everi.pages;

import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.helper.Webutility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Personal_Information {


	public Personal_Information() {
		Fname = "//input[@placeholder='First Name']";
		Lname = "//input[@placeholder='Last Name']";
		AKAFname = "//input[@placeholder='AKA First Name']";
		AKALname = "//input[@placeholder='AKA Last Name']";
		DOB = "//input[@placeholder='Date of Birth']";
		Mothersmaiden = "//input[@id='mat-input-11']";
		Gender = "//span[text()='Gender']";
		Maritalstatus = "//span[text()='Marital Status']";
		//Country="//span[@class='mat-select-placeholder ng-tns-c14-26 ng-star-inserted']";
		Country = "(//input[text()='Country'])[1]";
		Zipcode = "//input[@placeholder='Zip Code']";
		Zipcode1= "//*[@id=\"mat-input-47\"]";
		Zipcode2="";
		//Streetline1="//input[@id='mat-input-13']";
		Streetline1 = "//input[@placeholder='Street Line 1']";
		Street1line1="//*[@id=\"mat-input-48\"]";
		Street2line1="";

		City = "//input[@id='mat-input-15']";
		State = "//span[@class='mat-select-placeholder ng-tns-c14-103 ng-star-inserted']";
		Addresstype = "//span[text()='Address Type']";
		Addresstype1="//*[@id=\"mat-select-28\"]/div/div[1]/span";
		Addresstype2="";
		Yearataddress = "//span[text()='Years At Address']";
		Yearataddress1="//*[@id=\"mat-select-29\"]/div/div[1]/span";
		Yearataddress2="";
		Phonetype = "//span[text()='Primary Phone Type']";
		Phone = "//input[@id='mat-input-16']";
		Email = "//input[@placeholder='EMail']";
		Preferredcontactmenthod = "//span[text()='Preferred Contact Method']";
		Identification = "//input[@placeholder='Social Security Number']";
		Typeofidentification = "//span[text()='Type Of Identification']";
		Passportnumber = "//input[@placeholder='Passport Number']";
		Passportcountry = "//span[text()='Issuing Country']";
		Idexpiration = "//input[@placeholder='ID Expiration Date']";
		Nextbutton = "//div[3]//div[1]//div[1]//div[1]//button[2]";
		Financialinfotitle = "//h5[contains(text(),'Financial Institution Details')]";
		addrcountry = "//mat-option[1]//span[1]";
		addrcountryicon = "(//span[text()='Country'])[1]";
		addrcountryicon1 = "(//div[@class='mat-select-value'])[11]";
		addrcountryicon2 = "(//span[text()='Country'])[3]";
		Issuingcountry = "//mat-option[1]//span[1]";
		additionaladd1 = "(//div[text()='Additional Address Details'])[1]";
		additionaladd2 = "(//div[text()='Additional Address Details'])[2]";
	}

	String Fname;
	String Lname;
	String AKAFname;
	String AKALname;
	String DOB;
	String Mothersmaiden;
	String Gender;
	String Maritalstatus;
	String Country;
	String Zipcode;
	String Zipcode1;
	String Zipcode2;
	String Streetline1;
	String Street1line1;
	String Street2line1;
	String City;
	String State;
	String Addresstype;
	String Addresstype1;
	String Addresstype2;
	String Yearataddress;
	String Yearataddress1;
	String Yearataddress2;
	String Phonetype;
	String Phone;
	String Email;
	String Preferredcontactmenthod;
	String Identification;
	String Typeofidentification;
	String Passportnumber;
	String Passportcountry;
	String Idexpiration;
	String Nextbutton;
	String Financialinfotitle;
	String addrcountry;
	String addrcountryicon;
	String addrcountryicon1;
	String addrcountryicon2;
	String Issuingcountry;
	String additionaladd1;
	String additionaladd2;
	int count=0;

	Webutility webutil = new Webutility();

	DriverHelper driver = new DriverHelper(GlobalVariables.webDriver);


	public void personalpage() {
		System.out.println("Personal info is displayed");
	}

	public void enter_firstname() throws AutomationException, IOException {
		WebElement element = driver.getwebElement(Fname, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("FirstName"));
	}

	public void enter_lastname() throws AutomationException, IOException {
		WebElement element = driver.getwebElement(Lname, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("LastName"));

	}

	public void enter_akafirstname() throws AutomationException, IOException {

		WebElement element = driver.getwebElement(AKAFname, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("AkaFirstName"));

	}

	public void enter_akalastname() throws AutomationException, IOException {
		WebElement element = driver.getwebElement(AKALname, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("AkaLastName"));

	}

	public void enter_Mothersmaidenname() throws AutomationException, IOException {
		WebElement element = driver.getwebElement(DOB, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("DOB"));

	}

	public void enter_dob() throws AutomationException, IOException {
		WebElement element = driver.getwebElement(Mothersmaiden, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("MothersMaiden"));
	}


	public void select_patrongender() throws AutomationException, InterruptedException {

		By by = By.xpath(Gender);
		driver.waitUntilElementPresent(by, 30);
		WebElement element = driver.getwebElement(Gender, LocatorType.XPATH);
		driver.click(element);
		String text = GlobalVariables.testDataMap.get("Gender");
		webutil.selectTextInDropDown(text);

	}


	public void select_maritalstatus() throws AutomationException, InterruptedException {
		By by = By.xpath(Maritalstatus);
		driver.waitUntilElementPresent(by, 30);
		WebElement element = driver.getwebElement(Maritalstatus, LocatorType.XPATH);
		driver.click(element);
		String text = GlobalVariables.testDataMap.get("MaritalStatus");
		webutil.selectTextInDropDown(text);
	}


	public void select_addresscountry() throws AutomationException, InterruptedException {

		By by = By.xpath(addrcountryicon);
		driver.waitUntilElementPresent(by, 30);
		WebElement element = driver.getwebElement(addrcountryicon, LocatorType.XPATH);
		driver.click(element);
		By by1 = By.xpath(addrcountry);
		driver.waitUntilElementPresent(by1, 30);
		WebElement element1 = driver.getwebElement(addrcountry, LocatorType.XPATH);
		driver.click(element1);

	}


	public void enter_addresszipcode(int index) throws AutomationException, IOException {

		switch (index) {
			case 1:
				WebElement element = driver.getwebElement(Zipcode, LocatorType.XPATH);
				driver.sendKeys(element, GlobalVariables.testDataMap.get("AddressZipcode"));
				break;
			case 2:
				WebElement element1= driver.getwebElement(Zipcode1, LocatorType.XPATH);
				driver.sendKeys(element1, GlobalVariables.testDataMap.get("AddressZipcode1"));
				break;
			case 3:
				WebElement element2 = driver.getwebElement(Zipcode2, LocatorType.XPATH);
				driver.sendKeys(element2, GlobalVariables.testDataMap.get("AddressZipcode2"));
				break;
		}
	}

	public void enter_addressstreetline1(int index) throws AutomationException, IOException, InterruptedException {
		Thread.sleep(3000);
		switch (index) {
			case 1:
				By by = By.xpath(Streetline1);
				driver.waitUntilElementPresent(by, 100);
				WebElement element = driver.getwebElement(Streetline1, LocatorType.XPATH);
				driver.sendKeys(element, GlobalVariables.testDataMap.get("AddressStreetLine1"));
				break;
			case 2:
				By by1 = By.xpath(Street1line1);
				driver.waitUntilElementPresent(by1, 100);
				WebElement element1 = driver.getwebElement(Street1line1, LocatorType.XPATH);
				driver.sendKeys(element1, GlobalVariables.testDataMap.get("Address1StreetLine1"));
				break;
			case 3:
				By by2 = By.xpath(Street2line1);
				driver.waitUntilElementPresent(by2, 100);
				WebElement element2 = driver.getwebElement(Street2line1, LocatorType.XPATH);
				driver.sendKeys(element2, GlobalVariables.testDataMap.get("Address2StreetLine1"));
				break;
		}

	}

	public void select_addresstype(int index) throws AutomationException, InterruptedException {

		switch(index){
			case 1:
				By by = By.xpath(Addresstype);
				driver.waitUntilElementPresent(by, 100);
				WebElement element = driver.getwebElement(Addresstype, LocatorType.XPATH);
				driver.clickNoWait(element,100);
				String text = GlobalVariables.testDataMap.get("Addresstype");
				webutil.selectTextInDropDown(text);
				break;
			case 2:
				By by1 = By.xpath(Addresstype1);
				driver.waitUntilElementPresent(by1, 100);
				WebElement element1 = driver.getwebElement(Addresstype1, LocatorType.XPATH);
				driver.clickNoWait(element1,100);
				String text1 = GlobalVariables.testDataMap.get("Addresstype1");
				webutil.selectTextInDropDown(text1);

				break;
			case 3:
				By by2 = By.xpath(Addresstype2);
				driver.waitUntilElementPresent(by2, 100);
				WebElement element2 = driver.getwebElement(Addresstype2, LocatorType.XPATH);
				driver.click(element2);
				String text2 = GlobalVariables.testDataMap.get("Addresstype2");
				webutil.selectTextInDropDown(text2);
				break;
		}


	}

	public void select_yearataddress(int index) throws AutomationException, InterruptedException {

		switch (index) {
			case 1:
				By by = By.xpath(Yearataddress);
				driver.waitUntilElementPresent(by, 30);
				WebElement element = driver.getwebElement(Yearataddress, LocatorType.XPATH);
				driver.click(element);
				String text = GlobalVariables.testDataMap.get("YearAtAddress");
				webutil.selectTextInDropDown(text);
				break;
			case 2:
				By by1 = By.xpath(Yearataddress1);
				driver.waitUntilElementPresent(by1, 30);
				WebElement element1 = driver.getwebElement(Yearataddress1, LocatorType.XPATH);
				driver.click(element1);
				String text1 = GlobalVariables.testDataMap.get("YearAtAddress1");
				webutil.selectTextInDropDown(text1);
				break;
			case 3:
				By by2 = By.xpath(Yearataddress2);
				driver.waitUntilElementPresent(by2, 30);
				WebElement element2 = driver.getwebElement(Yearataddress2, LocatorType.XPATH);
				driver.click(element2);
				String text2 = GlobalVariables.testDataMap.get("YearAtAddress2");
				webutil.selectTextInDropDown(text2);
				break;
		}
	}

	public void address(int index) throws AutomationException, InterruptedException, IOException {
		select_addresscountry();
		enter_addresszipcode(index);
		enter_addressstreetline1(index);
		select_addresstype(index);
		select_yearataddress(index);

	}

	public void address1(int index) throws AutomationException, InterruptedException, IOException {
		boolean status= false;
		WebElement ele = null;
		try {
			ele = driver.getwebElement(additionaladd1, LocatorType.XPATH);
		}
		catch(NoSuchElementException e) {
			status =true;

		}
		if(!status) {
			boolean element = driver.isElementPresent(ele);
			if (element) {
				select_addresscountry();
				enter_addresszipcode(index);
				enter_addressstreetline1(index);
				select_addresstype(index);
				select_yearataddress(index);
			}
		}
	}

	public void address2(int index) throws AutomationException, InterruptedException, IOException {

		boolean status= false;
		WebElement ele = null;
		try {
			 ele = driver.getwebElement(additionaladd2, LocatorType.XPATH);
		 }
		catch(NoSuchElementException e) {
		  status =true;


		 }
             if(!status) {
				 boolean element = driver.isElementPresent(ele);
				 if (element) {
					 select_addresscountry();
					 enter_addresszipcode(index);
					 enter_addressstreetline1(index);
					 select_addresstype(index);
					 select_yearataddress(index);

				 }
			 }
		 }





 	public void select_primayphonetype()throws AutomationException, InterruptedException {
			By by = By.xpath(Phonetype);
			driver.waitUntilElementPresent(by, 30);
			WebElement element = driver.getwebElement(Phonetype, LocatorType.XPATH);
			driver.click(element);
			String text = GlobalVariables.testDataMap.get("PrimaryPhoneType");
			webutil.selectTextInDropDown(text);

		}

		public void select_primaryphone () throws AutomationException, IOException {

			WebElement element = driver.getwebElement(Phone, LocatorType.XPATH);
			driver.sendKeys(element, GlobalVariables.testDataMap.get("PrimaryPhone"));

		}

		public void enter_patronemail () throws AutomationException, IOException {
			WebElement element = driver.getwebElement(Email, LocatorType.XPATH);
			driver.sendKeys(element, GlobalVariables.testDataMap.get("Email"));

		}

		public void enter_preferredcontactmethod () throws AutomationException, InterruptedException {
			By by = By.xpath(Preferredcontactmenthod);
			driver.waitUntilElementPresent(by, 30);
			WebElement element = driver.getwebElement(Preferredcontactmenthod, LocatorType.XPATH);
			driver.click(element);
			String text = GlobalVariables.testDataMap.get("PreferredContactMethod");
			webutil.selectTextInDropDown(text);

		}

		public void enter_patronidentification () throws AutomationException, IOException {
			WebElement element = driver.getwebElement(Identification, LocatorType.XPATH);
			driver.sendKeys(element, GlobalVariables.testDataMap.get("Identification"));

		}

		public void select_typeofidentification ()throws AutomationException, InterruptedException {
			By by = By.xpath(Typeofidentification);
			driver.waitUntilElementPresent(by, 30);
			WebElement element = driver.getwebElement(Typeofidentification, LocatorType.XPATH);
			driver.click(element);
			String text = GlobalVariables.testDataMap.get("TypeOfIdentification");
			webutil.selectTextInDropDown(text);

		}

		public void select_passportnumber () throws AutomationException, IOException {
			WebElement element = driver.getwebElement(Passportnumber, LocatorType.XPATH);
			driver.sendKeys(element, GlobalVariables.testDataMap.get("PassportNumber"));
		}

		public void select_passportissuingccountry () throws AutomationException, InterruptedException {

			By by = By.xpath(Passportcountry);
			driver.waitUntilElementPresent(by, 30);
			WebElement element = driver.getwebElement(Passportcountry, LocatorType.XPATH);
			driver.click(element);
			//String text= GlobalVariables.testDataMap.get("IssuingCountry");
			//webutil.selectTextInDropDown(text);
			By by1 = By.xpath(Issuingcountry);
			driver.waitUntilElementPresent(by1, 30);
			WebElement element1 = driver.getwebElement(Issuingcountry, LocatorType.XPATH);
			driver.click(element1);
		}

		public void enter_idexpirydate () throws AutomationException, IOException {
			WebElement element = driver.getwebElement(Idexpiration, LocatorType.XPATH);
			driver.sendKeys(element, GlobalVariables.testDataMap.get("IDExpirationDate"));

		}

		public void click_nextbutton () throws AutomationException {
			WebElement element = driver.getwebElement(Nextbutton, LocatorType.XPATH);
			driver.click(element);

		}

		public void financial_information_tab_should_display () {
			By by = By.xpath(Financialinfotitle);
			driver.waitUntilElementPresent(by, 30);
			String Expectedresult = "Financial Institution Details";
			WebElement element = driver.getwebElement(Financialinfotitle, LocatorType.XPATH);
			String title = driver.gettext(element);
			webutil.verify(Expectedresult, title);


		}


	}

