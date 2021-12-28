package com.everi.stepdefinitions;

import com.everi.Helper.GlobalVariables;
import com.everi.Test.ProjectGlobalVariables;
import com.everi.driver.Driver;
import com.everi.driver.DriverType;
import com.everi.exception.AutomationException;
import com.everi.util.Util;
import com.everi.util.VideoRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;


public class Hook  {

	public static final String RED_BOLD_BRIGHT = "\033[1;91m"; // RED
	public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE
	public static final String ANSI_RESET = "\u001B[0m";
	static Logger logger = LogManager.getLogger(Hook.class);
	public static String TestCaseID = null;
	private static VideoRecorder videoReord = null;
	Driver driver = new Driver();

	// Runs before every scenario
	@Before
	
	public void before(Scenario scenario) throws Exception {
		
		  logger.info("jagan");
		FileInputStream fileInputStream = null;
		
		try {
			String dataExcel = ProjectGlobalVariables.sscaProperties.getProperty("--ExcelName").replaceAll("[\"]", "");
			System.out.println(dataExcel);
			Util util = new Util();
			String scenario_Name = scenario.getName();
			GlobalVariables.currentTestCaseID = scenario_Name.substring(scenario_Name.indexOf("(") + 1,
					scenario_Name.indexOf(")"));
			Collection<String> scenarioTags = scenario.getSourceTagNames();
			logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			logger.info(scenarioTags.toString());
			logger.info(WHITE_BACKGROUND + RED_BOLD_BRIGHT + scenario_Name + ANSI_RESET);
			// System.out.println(WHITE_BACKGROUND+RED_BOLD_BRIGHT+"scenario name is
			// "+scenario_Name+ANSI_RESET);

			// GlobalVariables.currentTestCaseID = scenario_Name;
			if (videoReord == null) {
				videoReord = new VideoRecorder();
			}
			fileInputStream = new FileInputStream("src/main/resources/Datasheet/"+dataExcel+".xlsx");
			driver.runModeConfig();
			GlobalVariables.webDriver
					.get(ProjectGlobalVariables.sscaProperties.getProperty("--SSCAURL"));
			GlobalVariables.webDriver.manage().window().maximize();
			videoReord.startRecording();
			logger.info("Starting video recording for current scenario");

			// Reading the excel file and get the current test case column of data from
			// excel

			Util.loadTestDataDynamicallyThroughHashmap(fileInputStream, ProjectGlobalVariables.sscaProperties.getProperty("--WORKSHEET").replaceAll("[\"]", ""));
			GlobalVariables.testDataMap = GlobalVariables.testData.get(GlobalVariables.currentTestCaseID);
			System.out.println(GlobalVariables.testDataMap);
			ProjectGlobalVariables.scenario = scenario;

			GlobalVariables.scenario = scenario;
			setScenario(scenario);
		} catch (AutomationException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			{
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
						logger.info("Exception occurs in reading test data from excel..");
					}
				}
			}
		}
	}

	// runs after every scenari
	@After
	public void after(Scenario scenario) throws Exception {
		System.out.println("After module");

		try {
			driver.closeDriverInstance();
		} catch (AutomationException e) {
			e.printStackTrace();
		}

		if (scenario.isFailed()) {
			if (GlobalVariables.winiumDriver != null) {
				String driverType = "WINIUM";
				driver.quitIndependentDriver(DriverType.WINIUM);
				driver.stopIndependentService(driverType);
			} else if (GlobalVariables.webDriver != null) {
				String driverType = "CHROME";
				driver.quitIndependentDriver(DriverType.CHROME);
				// driverHandler.stopIndependentService(driverType);
			}
		}
		videoReord.stopRecording();
		logger.info("Stopping video recording for current scenario");
	}

	public void setScenario(Scenario actualScenario) {
		ProjectGlobalVariables.scenario = actualScenario;
		logger.info("setting test Global scenario varialbe");
	}
}
