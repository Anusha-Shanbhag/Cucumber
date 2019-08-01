package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentTypes;

public class ConfigReader {

	private Properties property = new Properties();
	private static String propertyFilePath = "configs//config.properties";

	public ConfigReader() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				property.load(reader);
				reader.close();
			} catch (IOException e) {
				System.out.println("Can not read property ");
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Property file not found");
			e.printStackTrace();
		}
	}

	public String getDriverPath() {
		String driverPath = property.getProperty("driverPath");
		System.out.println("driverPath : "+driverPath);
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("Driver path not found");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = property.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Config.properties file.");
	}

	public String getApplicationUrl() {
		String url = property.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public DriverType getDriverType() {
		String browserName = property.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentTypes getEnvironment() {
		String environmentName = property.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentTypes.LOCAL;
		else if (environmentName.equals("remote"))
			return EnvironmentTypes.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = property.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = property.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

}
