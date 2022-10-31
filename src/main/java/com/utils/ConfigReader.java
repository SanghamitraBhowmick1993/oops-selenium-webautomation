package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	public static Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getUrl() {
		return init_prop().getProperty("urlWeathershop");
	}

	public static String getusernmeValue() {
		return init_prop().getProperty("usernm");
	}

	public static String getpasswordValue() {
		return init_prop().getProperty("password");
	}

	public static String emailDetails() {
		return init_prop().getProperty("email");
	}

	public static String cardDetails() {
		return init_prop().getProperty("cardNumber");
	}

	public static String monthYrDetails() {
		return init_prop().getProperty("monthYear");
	}

	public static String cvcDetails() {
		return init_prop().getProperty("cvc");
	}
	public static String zipDetails() {
		return init_prop().getProperty("zip");
	}
}
