package com.everi.helper;

import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.everi.Test.ProjectGlobalVariables;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Webutility extends ProjectGlobalVariables {


	DriverHelper driver = new DriverHelper(GlobalVariables.webDriver);


	public void verify(String expected, String actual) {
		Assert.assertEquals(expected, actual);

	}


	public void selectTextInDropDown(String text) throws AutomationException, InterruptedException {
		String dropdown = "//span[normalize-space(text())='" + text + "']";
		By by = By.xpath(dropdown);
		WebElement element = driver.getwebElement(dropdown, LocatorType.XPATH);
		driver.waitUntilElementPresent(by, 60);
		driver.clickNoWait(element, 100);

	}

	public void windowhandle() {
		Set<String> windowHandles = GlobalVariables.webDriver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		GlobalVariables.webDriver.switchTo().window(windowHandlesList.get(0));
	}

	public void winAppSetUp() throws IOException {

		String command = GlobalVariables.everi_property.getProperty("--WINAPP_DRIVER_PATH");
		ProcessBuilder builder = new ProcessBuilder(command).inheritIO();
		builder.start();

	}

	public void waitUntilElementPresent(By locator, long timeunit) {

		WebDriverWait wait= new WebDriverWait(winAppDriver,timeunit);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public void waitUntilclick(By locator, long timeunit) {

		WebDriverWait wait= new WebDriverWait(winAppDriver,timeunit);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

	}

	public void tearDown() {
		winAppDriver.close();
		winAppDriver.quit();

	}
}
