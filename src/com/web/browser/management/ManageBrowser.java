package com.web.browser.management;

/**
*
* 管理类浏览器抽象类
* 定义管理系统登录方法
* @name         Browser类名
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
	//定义浏览器驱动存放路径
	public static String WEB_DRIVER_LOCAL = "E:\\Develop\\chromedriver.exe";
	//定义全局浏览器驱动对象
	public WebDriver driver = null;
	
	public ManageBrowser(String web_driver_loacl, String webType) {
		if(!"".equals(web_driver_loacl) && web_driver_loacl != null) {
			this.WEB_DRIVER_LOCAL = web_driver_loacl;
		}
		
		if("".equals(webType) || webType == null) {
			//默认chrome驱动-谷歌浏览器
			init("chrome");
		} else {
			init(webType);
		}
	}
	
	/**
	 * 系统登录方法
	 * @param strURL
	 * @return
	 */
	public abstract boolean login(String strURL, String loginName, String passWord);
	
	/**
	 * 初始化系统属性
	 * @param webType
	 */
	public void init(String webType) {
		if("chrome".equals(webType)) {
			//chrome驱动-谷歌浏览器
			File file = new File(this.WEB_DRIVER_LOCAL);
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		} else {
			//默认chrome驱动-谷歌浏览器
			File file = new File(this.WEB_DRIVER_LOCAL);
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		}
	}
}
