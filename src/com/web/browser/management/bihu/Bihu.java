package com.web.browser.management.bihu;

import java.util.List;

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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.browser.management.ManageBrowser;

public class Bihu extends ManageBrowser {
	//获取浏览器的对象  
	private Navigation navigation = null;
	//定义登录用户
	private String loginName = "";
	//定义登录密码
	private String passWord = "";
	//关注进入关注界面状态的句柄
	private String focusHandle = "";
	
	
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
	
	/**
	 * 登录币户主页
	 * @param strURL
	 * @param loginName
	 * @param passWord
	 */
	public boolean login(String strURL, String loginName, String passWord) {
		boolean loadcomplete = false;
		//打开对应网站
		this.navigation.to(strURL);
		//初始化用户名
		this.driver.findElement(By.id("loginName")).sendKeys(loginName);
		//初始化密码
		this.driver.findElement(By.id("password")).sendKeys(passWord);
		//点击登录按钮
		this.driver.findElement(By.tagName("form")).submit();
		
		try {
			//等待页面加载完成
			//WebDriverWait wait = new WebDriverWait(driver, 6000);
			Thread.sleep(1000);
			//判断是否进入个人主页
			loadcomplete = this.driver.findElement(By.xpath("//img[@alt='个人中心']")).isDisplayed();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			loadcomplete = false;
		}
		
		return loadcomplete;
	}

	/**
	 * 进入关注页面状态
	 * @return
	 */
	public boolean intoFocus() {
		this.driver.findElement(By.linkText("关注")).click();
		this.focusHandle = this.driver.getWindowHandle();
		this.driver = this.driver.switchTo().window(this.focusHandle);
		
		return true;
	}
	
	
	public Article articleList() {
		Article article = new Article();
		
		//获取第一篇文章
		WebElement articleList = this.driver.findElements(By.tagName("li")).get(0);
		
		String author = articleList.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div/ul[2]/li[1]/div[1]/div")).findElements(By.tagName("p")).get(0).getText();
		String time = articleList.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div/ul[2]/li[1]/div[1]/div")).findElements(By.tagName("p")).get(1).getText();
		
		
		
		return article;
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
