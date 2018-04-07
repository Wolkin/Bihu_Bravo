package com.web.browser.management;

/**
*
* �����������������
* �������ϵͳ��¼����
* @name         Browser����
* @author       Wolkin   jjwlove@126.com
* @createtTime  2018-04-07
* @version      1.0
* @since        1.0
*
*/

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.web.browser.Browser;

public abstract class ManageBrowser implements Browser {
	//����������������·��
	public static String WEB_DRIVER_LOCAL = "E:\\Develop\\chromedriver.exe";
	//����ȫ���������������
	public WebDriver driver = null;
	
	public ManageBrowser(String web_driver_loacl, String webType) {
		if(!"".equals(web_driver_loacl) && web_driver_loacl != null) {
			this.WEB_DRIVER_LOCAL = web_driver_loacl;
		}
		
		if("".equals(webType) || webType == null) {
			//Ĭ��chrome����-�ȸ������
			init("chrome");
		} else {
			init(webType);
		}
	}
	
	/**
	 * ϵͳ��¼����
	 * @param strURL
	 * @return
	 */
	public abstract boolean login(String strURL, String loginName, String passWord);
	
	/**
	 * ��ʼ��ϵͳ����
	 * @param webType
	 */
	public void init(String webType) {
		if("chrome".equals(webType)) {
			//chrome����-�ȸ������
			File file = new File(this.WEB_DRIVER_LOCAL);
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		} else {
			//Ĭ��chrome����-�ȸ������
			File file = new File(this.WEB_DRIVER_LOCAL);
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		}
	}
}
