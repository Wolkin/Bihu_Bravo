package com.web.browser.management.bihu;

/**
*
* Bihu实体模型
* 用于登录
*
* @name         Bihu类名
* @author       Wolkin   jjwlove@126.com
* @createtTime  2018-04-07
* @version      1.0
* @since        1.0
*
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.browser.management.ManageBrowser;

public class Bihu extends ManageBrowser {
	//获取浏览器的对象  
	private Navigation navigation = null;
	//定义登录用户
	private String loginName = "";
	//定义登录密码
	private String passWord = "";
	
	/**
	 * 构造函数，初始化浏览器驱动和浏览器系统参数
	 * @param web_driver_loacl
	 * @param webType
	 */
	public Bihu(String web_driver_loacl, String webType) {
		super(web_driver_loacl, webType);
		//打开chrome浏览器
		this.driver = new ChromeDriver();
		//最大化浏览器窗口
		this.driver.manage().window().maximize();
		//获取浏览器的对象  
		this.navigation = driver.navigate();
	}
	
	
	public boolean login(String strURL, String loginName, String passWord) {
		//打开对应网站
		this.navigation.to(strURL);
		//初始化用户名
		this.driver.findElement(By.id("loginName")).sendKeys(loginName);
		//初始化密码
		this.driver.findElement(By.id("password")).sendKeys(passWord);
		//点击登录按钮
		this.driver.findElement(By.tagName("form")).submit();
		
		//获取当前窗口句柄
		String currentWindow = driver.getWindowHandle();
		
		this.driver.findElement(By.xpath("//img[@alg='个人中心']"));
		//等待页面加载完成
		//WebDriverWait wait = new WebDriverWait(driver, 70);
		//wait.until(ExpectedConditions.titleIs("O..."));
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	/**
	 * 
	 * @param passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
