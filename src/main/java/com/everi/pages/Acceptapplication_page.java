package com.everi.pages;


import com.everi.Helper.GlobalVariables;
import com.everi.Test.ProjectGlobalVariables;
import com.everi.helper.Webutility;
import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Acceptapplication_page extends ProjectGlobalVariables {

    Webutility webutil=new Webutility();
    Disclosure dis=new Disclosure();


    String username;
    String password;
    String checkbox;
    String login;
    String creditapplication;
    String search;
    String applicationid;
    String submit;
    String view;
    String applicationtab;
    String accept;
    String accept_yes;
    String verify_accept;
    String ok;
    String loginpage;


    public Acceptapplication_page(){

        username="UsernameTextBox";
        password="passwordBox";
        checkbox="CheckBox_Disclaimer";
        login="Accept, and Log In";
        creditapplication="//Text[@AutomationId='creditButtonTextBlock']";
        search="S";
        applicationid="TextBox";
        submit="Search";
        view="View";
        applicationtab="_2. Application";
        accept="Accept, to EST";
        accept_yes="Yes";
        verify_accept="Application has been accepted.";
        ok="_OK";
        loginpage="LogInView";

    }

    public void launch_application() throws IOException {

        webutil.winAppSetUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", GlobalVariables.everi_property.getProperty("--WINDOWS_APPLICATION_PATH"));
        winAppDriver = new WindowsDriver(new URL(GlobalVariables.everi_property.getProperty("--WINAPP_DRIVER_URL")), capabilities);
        winAppDriver.manage().window().maximize();
    }

    public void login_application() {
        By by = By.className(loginpage);
        webutil.waitUntilElementPresent(by, 200);
        winAppDriver.findElementByAccessibilityId(username).sendKeys(ProjectGlobalVariables.sscaProperties.getProperty("--Username"));
        winAppDriver.findElementByAccessibilityId(password).sendKeys(ProjectGlobalVariables.sscaProperties.getProperty("--Password"));
        winAppDriver.findElementByAccessibilityId(checkbox).click();
        winAppDriver.findElementByName(login).click();

    }

    public void click_creditapplication()
    {
        By by = By.xpath(creditapplication);
        webutil.waitUntilElementPresent(by, 200);
        winAppDriver.findElementByXPath(creditapplication).click();
    }

    public void click_searchicon(){
        By by = By.name(search);
        webutil.waitUntilclick(by,200);

    }

    public void type_applicationId(){
        By by = By.className(applicationid);
        webutil.waitUntilElementPresent(by, 100);
        List<WebElement> element= winAppDriver.findElementsByClassName(applicationid);
        WebElement ele = element.get(1);
        ele.sendKeys(dis.applicationId);

    }

    public void click_submit(){

        By by = By.name(submit);
        webutil.waitUntilclick(by,100);
    }

    public void select_application(){
        By by = By.name(dis.applicationId);
        webutil.waitUntilclick(by,100);

        By by1 = By.name(view);
        webutil.waitUntilclick(by1,100);
    }

    public void navigate_applicationtab(){
        By by = By.name(applicationtab);
        webutil.waitUntilclick(by,100);
    }

    public void accept_application(){
        By by = By.name(accept);
        webutil.waitUntilclick(by,100);
    }

    public void click_yes(){
        By by = By.name(accept_yes);
        webutil.waitUntilclick(by,100);
    }
    public void verify_accept_done(){
        By by = By.name(verify_accept);
        webutil.waitUntilElementPresent(by, 100);
        String expected="Application has been accepted.";
        String actual= winAppDriver.findElementByName(verify_accept).getText();
        Assert.assertEquals(expected,actual);

    }

    public void click_ok(){
        By by = By.name(ok);
        webutil.waitUntilclick(by,100);
        webutil.tearDown();
    }



}
