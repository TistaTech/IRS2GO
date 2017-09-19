package net.serenity.bdd.junit.cucumber.stepDef;

import java.util.Properties;

import org.junit.rules.ErrorCollector;

public class GenericDeclarationClass {
	
	public static String Configpath = System.getProperty("user.dir") + "\\configuration.properties";
	public final ErrorCollector collector = new ErrorCollector();
	public static Properties prop;
	
}
