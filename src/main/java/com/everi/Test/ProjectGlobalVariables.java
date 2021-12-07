package com.everi.Test;


import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.Scenario;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ProjectGlobalVariables {
	public static Properties sscaProperties = new Properties();
    public static Map<String, Properties> propertyFileMap = new HashMap<String, Properties>();
    public static Connection sqlConnection;
    public static String refernce;
//    public static WiniumDriver winiumDriver;
    public static WindowsDriver winAppDriver;
    public static Scenario scenario;
	
}
