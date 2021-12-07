package com.everi.pages;

import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.helper.Webutility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class Landing_page {

	static Logger logger = LogManager.getLogger(Landing_page.class);
	
	public Landing_page() {
        
		accept="//input[@id='mat-input-0']";
		next_button="//i[normalize-space()='keyboard_arrow_right']";
		dashboard_screen_title="//div[@class='heading-style brand-heading']";	
		
	}

	private final String accept;
	private final String next_button;
	private final String dashboard_screen_title;	
    DriverHelper driver=new DriverHelper(GlobalVariables.webDriver);
	Webutility webutil=new Webutility();
    

     
   	public void enter_accept() throws AutomationException, IOException {
		
		By by=By.xpath(accept);		
		driver.waitUntilElementPresent(by,30);
		WebElement element=driver.getwebElement(accept,LocatorType.XPATH);
		driver.sendKeys(element, GlobalVariables.testDataMap.get("T&C"));
	
	}

	public void next_button() throws AutomationException {	    
		WebElement element=driver.getwebElement(next_button,LocatorType.XPATH);
		driver.click(element);

	}

	public void dashboard_screen_should_display() {	 
		By by=By.xpath(dashboard_screen_title);		
		driver.waitUntilElementPresent(by,30);
		String Expectedresult="Credit Application";	
		WebElement element=driver.getwebElement(dashboard_screen_title,LocatorType.XPATH);
		String title= driver.gettext(element);
		webutil.verify(Expectedresult,title);


	}

}
