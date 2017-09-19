package net.serenity.bdd.junit.cucumber.stepDef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GenericHookClass extends GenericDeclarationClass {
	
	private static final String BAT_PATH = "C:\\Users\\\"Marat Metoff\"\\Desktop\\\"Random stuff\"\\Applications\\appium.bat";
	private static String cmd = "cmd /c start " + BAT_PATH;                         		
	private String processName = "cmd.exe";
	
	
	@Before
	public void beforeTest(Scenario scenario) throws Exception {
		appiumStop();
		appiumStart();
	}

	@After
	public void tearDown() throws Exception {
		appiumStop();
	}
	
//===============================================================================================	
	
	private boolean isRunning() throws Exception {
		Process listTasksProcess = Runtime.getRuntime().exec("tasklist");
		BufferedReader tasksListReader = new BufferedReader(new InputStreamReader(listTasksProcess.getInputStream()));
		String tasksLine;
		while ((tasksLine = tasksListReader.readLine()) != null) {
			if (tasksLine.contains(this.processName)) {
				return true;
			}
		}
		return false;
	}
	
	public void appiumStart() throws Exception {  
		Runtime.getRuntime().exec(cmd); 								
		Thread.sleep(10000);  
		}     

	public void appiumStop() throws Exception {
		if (isRunning()) {
			Runtime.getRuntime().exec("taskkill /IM " + this.processName);
		} else {
			System.out.println(this.processName + " is not running.");
		}
	}

}

	
	