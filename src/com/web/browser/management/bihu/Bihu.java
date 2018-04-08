package com.web.browser.management.bihu;

import java.util.List;

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
import org.openqa.selenium.NoSuchElementException;
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
	//��ע��Ա������������ 5 ƪ
	private Article articles[] = new Article[3];
	//��ע�����ע����״̬�ľ��
	private String focusHandle = "";
	
	
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
	
	/**
	 * ��¼�һ���ҳ
	 * @param strURL
	 * @param loginName
	 * @param passWord
	 */
	public boolean login(String strURL, String loginName, String passWord) {
		boolean loadcomplete = false;
		//�򿪶�Ӧ��վ
		this.navigation.to(strURL);
		//��ʼ���û���
		this.driver.findElement(By.id("loginName")).sendKeys(loginName);
		//��ʼ������
		this.driver.findElement(By.id("password")).sendKeys(passWord);
		//�����¼��ť
		this.driver.findElement(By.tagName("form")).submit();
		
		try {
			//�ȴ�ҳ��������
			//WebDriverWait wait = new WebDriverWait(driver, 6000);
			Thread.sleep(1000);
			//�ж��Ƿ���������ҳ
			loadcomplete = this.driver.findElement(By.xpath("//img[@alt='��������']")).isDisplayed();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			loadcomplete = false;
		}
		
		return loadcomplete;
	}

	public void doBravo() {
		intoFocus();
		articleList();
	}
	
	/**
	 * �����עҳ��״̬
	 * @return
	 */
	private boolean intoFocus() {
		this.driver.findElement(By.linkText("��ע")).click();
		this.focusHandle = this.driver.getWindowHandle();
		this.driver = this.driver.switchTo().window(this.focusHandle);
		
		
		return true;
	}
	
	
	public void articleList() {
		String author = "";
		String time = "";
		String title = "";
		String sum = "";
		String count = "";
		
		//��ȡ��һƪ����
		for(int i = 0 ; i < 3 ; i ++) {
			Article article = new Article();
			WebElement articleList = this.driver.findElements(By.tagName("li")).get(i);
			
			author = articleList.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div/ul[2]/li[1]/div[1]/div")).findElements(By.tagName("p")).get(0).getText();
			time = articleList.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div/ul[2]/li[1]/div[1]/div")).findElements(By.tagName("p")).get(1).getText();
			title = articleList.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div/ul[2]/li[1]/div[2]/div/div[1]")).getText();
			sum = articleList.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div/ul[2]/li[1]/div[2]/div/div[3]")).findElements(By.tagName("span")).get(0).getText();
			count = articleList.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div/ul[2]/li[1]/div[2]/div/div[3]")).findElements(By.tagName("span")).get(1).getText();
			System.out.println("�����ߡ���" + author + " | �����⡿��" + title + " | ��ʱ�䡿��" + time + " | ������" + sum + " | ����������" + count);
			
			article.setAuthor(author);
			article.setTime(time);
			article.setTitle(title);
			article.setSum(Double.parseDouble(sum));
			article.setCout(Integer.parseInt(count));
			
			articles[i] = article;
		}
		
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
