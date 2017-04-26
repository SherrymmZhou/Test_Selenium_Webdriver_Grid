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
	  baseUrl = "http://cn.bing.com/";								//设置测试url
	  DesiredCapabilities capability =new DesiredCapabilities(); 	 
	  capability.setBrowserName("firefox"); 						//设置浏览器为firefox，需要提前安装火狐浏览器，建议安装在默认路径
	  capability.setPlatform(Platform.VISTA);						//设置系统为VISTA
	  WebDriver driver=null; 										
	  try { 
	  driver = new RemoteWebDriver(new 
	         URL("http://192.168.1.111:4000/wd/hub"),capability); 	//根据上述设置创建driver。这里替换成实际使用的node机器的ip和端口号
                  //your_node_ip : port
	       } 
	          catch (MalformedURLException e) { 
	          e.printStackTrace(); 									//打印异常信息在程序中出错的位置及原因
	  } 
	  
	  driver.get(baseUrl);											//访问测试url
	  
	  WebElement searchElement = (new WebDriverWait(driver,10)).until(new ExpectedCondition<WebElement>(){
		  public WebElement apply (WebDriver wd){
		    		return wd.findElement(By.id("sb_form_q"));		//输入框元素searchElement的id是sb_form_q，在页面等待至此元素出现
		    	}
		  });

	  searchElement.clear(); 										//清空输入框
	  searchElement.sendKeys("WebDriver");							//在输入框中输入关键字"WebDriver"
	  driver.findElement(By.id("sb_form_go")).click(); 				//点击"搜索"按钮
	  
	  driver.quit();												//关闭driver
  } 
}
