package com.web.browser;

import java.io.File;

/**
*
* 浏览器接口类
* @name         Browser接口
* @author       Wolkin   jjwlove@126.com
* @createtTime  2018-04-07
* @version      1.0
* @since        1.0
*
*/


public interface Browser {
	
	/**
	 * 初始化系统属性
	 * @param webType
	 */
	public void init(String webType);
}
