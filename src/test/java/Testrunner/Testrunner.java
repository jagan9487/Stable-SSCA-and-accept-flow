package Testrunner;

import com.everi.Test.ProjectGlobalVariables;
import com.everi.driver.Driver;
import com.everi.exception.AutomationException;
import com.everi.report.TestReport;
import com.everi.util.Util;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
 features="src/test/resources/feature",
 glue={"com/everi/stepdefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "junit:target/JunitReport"
        },
  monochrome=true
  
 )

public class Testrunner {

    static Logger logger = LogManager.getLogger(Testrunner.class);
    static Driver driverHandler = new Driver();

    @BeforeClass
    public static void setup() throws InterruptedException, AutomationException {
        logger.info("Entering setup");
        
        ProjectGlobalVariables.sscaProperties = Util.getFileAsProperty("Properties/SSCA.properties");             
        com.everi.Helper.GlobalVariables.everi_property = Util.getFileAsProperty("Properties/everitest.properties");
        driverHandler.startService();
        logger.info("Exiting setup");
    }

    @AfterClass
    public static void tearDown() throws AutomationException {

        logger.info("Inside tear down");
        driverHandler.stopService();
        TestReport.flushTestReport();
        logger.info("End Of tear down");
    }
}
