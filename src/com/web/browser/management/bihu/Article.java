package com.web.browser.management.bihu;

/**
*
* Article实体模型
* 文章对象类,定义文章基本信息和方法
*
* @name         Article类名
* @author       Wolkin   jjwlove@126.com
* @createtTime  2018-04-08
* @version      1.0
* @since        1.0
*
*/

public class Article {
	//文章作者
	public String author = "";
	//发文时间
	public String time = "";
	//文章名称
	public String title = "";
	//文章获得金额
	public double sum = 0.00;
	//文章获得点赞数
	public int cout = 0;
	
	/**
	 * 
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * 
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getSum() {
		return sum;
	}
	
	/**
	 * 
	 * @param sum
	 */
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCout() {
		return cout;
	}
	
	/**
	 * 
	 * @param cout
	 */
	public void setCout(int cout) {
		this.cout = cout;
	}
}
