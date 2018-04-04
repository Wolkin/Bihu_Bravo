package com.web.bihu;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Bihu {
	public static void main(String[] args) {
		//System.setProperty("webdriver.ie.driver","E:\\Develop\\IEDriverServer.exe");
        //DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        //ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		
		File file = new File("E:\\Develop\\IEDriverServer.exe");  
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath()); 
		//打开IE浏览器
		WebDriver driver = new InternetExplorerDriver();
		
		//打开firefox浏览器
		//WebDriver fireFoxDriver = new FirefoxDriver();
		
		//打开HtmlUnit浏览器
		//WebDriver htmlUnitDriver = new HtmlUnitDriver(); 
		
		//打开chrome浏览器
		//WebDriver chromeDriver = new ChromeDriver();
		
		Navigation navigation = driver.navigate();//获取浏览器的对象  
		navigation.to("https://www.bihu.com");
		
	}
}
