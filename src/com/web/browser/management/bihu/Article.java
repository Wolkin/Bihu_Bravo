package com.web.browser.management.bihu;

/**
*
* Articleʵ��ģ��
* ���¶�����,�������»�����Ϣ�ͷ���
*
* @name         Article����
* @author       Wolkin   jjwlove@126.com
* @createtTime  2018-04-08
* @version      1.0
* @since        1.0
*
*/

public class Article {
	//��������
	public String author = "";
	//����ʱ��
	public String time = "";
	//��������
	public String title = "";
	//���»�ý��
	public double sum = 0.00;
	//���»�õ�����
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
