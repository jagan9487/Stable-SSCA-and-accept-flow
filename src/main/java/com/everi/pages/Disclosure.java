package com.everi.pages;

import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.helper.Webutility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Disclosure {

	static String applicationId;
	String Privacyclub;
	String Privacyeveri;
	String Termsandconditions;
	String Acknowledge;
	String Sign;
	String Submit;
	String Thankyou;
	String ApplicationId;
	
	public Disclosure() {
		
	   Privacyclub="(//div[@class='link ml-2'][normalize-space()='Read & Accept'])[1]";
	   Privacyeveri="(//div[@class='link ml-2'][normalize-space()='Read & Accept'])[2]";
	   Termsandconditions="(//div[@class='link ml-2'][normalize-space()='Read & Accept'])[3]";
	   Acknowledge="(//div[@class='mat-checkbox-inner-container'])[3]";
	   Sign="//canvas";
	   Submit="(//button[@class='btn btn-primary brand-primary pull-right mat-raised-button ng-star-inserted'])[4]";
	   Thankyou="//h4[normalize-space()='Thank You!']";
	   ApplicationId="//p[@class='ng-star-inserted']";
	   
  }

	Webutility webutil=new Webutility();
	DriverHelper driver=new DriverHelper(GlobalVariables.webDriver);
	

	public void disclosurepage() {
	 System.out.println("Disclosure page is displayed");
	 
	}	
	

	public void click_privacypolicies() throws AutomationException {
		WebElement element= driver.getwebElement(Privacyclub, LocatorType.XPATH);
		driver.click(element);
		webutil.windowhandle();
		WebElement element1=driver.getwebElement(Privacyeveri,LocatorType.XPATH );
		driver.click(element1);
		webutil.windowhandle();
		WebElement element2=driver.getwebElement(Termsandconditions,LocatorType.XPATH );
		driver.click(element2);
		webutil.windowhandle();
		WebElement element3=driver.getwebElement(Acknowledge,LocatorType.XPATH );
		driver.click(element3);

	}
	
	public void signature() {
		By by=By.xpath(Sign);
		driver.waitUntilElementPresent(by,100);
		WebElement signatureElement = driver.getwebElement(Sign,LocatorType.XPATH);
		Actions builder = new Actions(GlobalVariables.webDriver);
		builder.moveToElement(signatureElement, 135, 15) // start points x axis and y axis.
				.click().moveByOffset(200, 60) // 2nd points (x1,y1)
				.click().moveByOffset(100, 70)// 3rd points (x2,y2)
				.doubleClick().build().perform();
	}
	
	public void submit() throws AutomationException {
		WebElement element=driver.getwebElement(Submit,LocatorType.XPATH);
		driver.click(element);
		By by=By.xpath(Thankyou);
		driver.waitUntilElementPresent(by,100);
		String Expectedresult="Thank You!";
		WebElement element1=driver.getwebElement(Thankyou,LocatorType.XPATH);
		String title= driver.gettext(element1);
		webutil.verify(Expectedresult,title);

	}

	public void getApplicationId(){

		WebElement element=driver.getwebElement(ApplicationId,LocatorType.XPATH);
		String appId= driver.gettext(element);
		String[] elements= appId.split(" ");
		applicationId= elements[10];
		System.out.println(applicationId);

	}
	
	
}
