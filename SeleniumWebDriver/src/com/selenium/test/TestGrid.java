package com.selenium.test;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestGrid {
  private String baseUrl;
  @Test
  public void testGrid() throws Exception {	
	  baseUrl = "http://cn.bing.com/";								//���ò���url
	  DesiredCapabilities capability =new DesiredCapabilities(); 	 
	  capability.setBrowserName("firefox"); 						//���������Ϊfirefox����Ҫ��ǰ��װ�������������鰲װ��Ĭ��·��
	  capability.setPlatform(Platform.VISTA);						//����ϵͳΪVISTA
	  WebDriver driver=null; 										
	  try { 
	  driver = new RemoteWebDriver(new 
	         URL("http://192.168.1.111:4000/wd/hub"),capability); 	//�����������ô���driver�������滻��ʵ��ʹ�õ�node������ip�Ͷ˿ں�
                  //your_node_ip : port
	       } 
	          catch (MalformedURLException e) { 
	          e.printStackTrace(); 									//��ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
	  } 
	  
	  driver.get(baseUrl);											//���ʲ���url
	  
	  WebElement searchElement = (new WebDriverWait(driver,10)).until(new ExpectedCondition<WebElement>(){
		  public WebElement apply (WebDriver wd){
		    		return wd.findElement(By.id("sb_form_q"));		//�����Ԫ��searchElement��id��sb_form_q����ҳ��ȴ�����Ԫ�س���
		    	}
		  });

	  searchElement.clear(); 										//��������
	  searchElement.sendKeys("WebDriver");							//�������������ؼ���"WebDriver"
	  driver.findElement(By.id("sb_form_go")).click(); 				//���"����"��ť
	  
	  driver.quit();												//�ر�driver
  } 
}
