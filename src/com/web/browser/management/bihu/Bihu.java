package com.web.browser.management.bihu;

/**
*
* Bihuʵ��ģ��
* ���ڵ�¼
*
* @name         Bihu����
* @author       Wolkin   jjwlove@126.com
* @createtTime  2018-04-07
* @version      1.0
* @since        1.0
*
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.web.browser.management.ManageBrowser;

public class Bihu extends ManageBrowser {
	//��ȡ������Ķ���  
	private Navigation navigation = null;
	//�����¼�û�
	private String loginName = "";
	//�����¼����
	private String passWord = "";
	
	/**
	 * ���캯������ʼ������������������ϵͳ����
	 * @param web_driver_loacl
	 * @param webType
	 */
	public Bihu(String web_driver_loacl, String webType) {
		super(web_driver_loacl, webType);
		//��chrome�����
		this.driver = new ChromeDriver();
		//������������
		this.driver.manage().window().maximize();
		//��ȡ������Ķ���  
		this.navigation = driver.navigate();
	}
	
	
	public boolean login(String strURL, String loginName, String passWord) {
		//�򿪶�Ӧ��վ
		this.navigation.to(strURL);
		//��ʼ���û���
		this.driver.findElement(By.id("loginName")).sendKeys(loginName);
		//��ʼ������
		this.driver.findElement(By.id("password")).sendKeys(passWord);
		//�����¼��ť
		this.driver.findElement(By.tagName("form")).submit();
		
		//WebElement person = this.driver.getWindowHandle().findElement(By.partialLinkText("�ҵ���ҳ"));
		//System.out.println(person.isEnabled());
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
