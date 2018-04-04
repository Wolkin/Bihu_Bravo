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
		//��IE�����
		WebDriver driver = new InternetExplorerDriver();
		
		//��firefox�����
		//WebDriver fireFoxDriver = new FirefoxDriver();
		
		//��HtmlUnit�����
		//WebDriver htmlUnitDriver = new HtmlUnitDriver(); 
		
		//��chrome�����
		//WebDriver chromeDriver = new ChromeDriver();
		
		Navigation navigation = driver.navigate();//��ȡ������Ķ���  
		navigation.to("https://www.bihu.com");
		
	}
}
