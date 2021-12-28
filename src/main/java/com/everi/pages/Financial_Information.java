package com.everi.pages;

import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.helper.Webutility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Financial_Information {

	
	String Totalnetworth;
	String Totaldebt;
	String Nextbutton;
	String Disclosure_tile;
	
	public Financial_Information() {
		Totalnetworth="//input[@placeholder='Estimated Total Net Worth']";
		Totaldebt="//input[@placeholder='Estimated Total Debt']";
		Nextbutton="//div[4]//div[1]//div[1]//div[1]//button[2]";
		Disclosure_tile="//h5[normalize-space()='Terms and Conditions']";
		
	}
	
	Webutility webutil=new Webutility();
	DriverHelper driver=new DriverHelper(GlobalVariables.webDriver);
	
	public void financialpage() {
	System.out.println("Financial page is displayed");
	}	
	
	
	public void enter_estimatedtotalnetworth() throws AutomationException, IOException {
		WebElement element=driver.getwebElement(Totalnetworth, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("EstimatedTotalNetWorth"));

	}
	
	public void enter_estimatedtotaldebt() throws AutomationException, IOException {
		WebElement element=driver.getwebElement(Totaldebt, LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("EstimatedTotalDebt"));
	}
	
	public void click_on_next_button() throws AutomationException {
		WebElement element=driver.getwebElement(Nextbutton, LocatorType.XPATH);
		driver.click(element);
	}

	public void disclosure_tab_should_display() {
		By by=By.xpath(Disclosure_tile);
		driver.waitUntilElementPresent(by,30);
		String Expectedresult="Terms and Conditions";
		WebElement element=driver.getwebElement(Disclosure_tile,LocatorType.XPATH);
		String title= driver.gettext(element);
		webutil.verify(Expectedresult,title);

	}
	
}
