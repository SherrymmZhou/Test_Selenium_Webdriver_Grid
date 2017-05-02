package com.selenium.test;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

  public class TestBing {
     private WebDriver driver;
     private String baseUrl;

@Before
  public void setUp() throws Exception {
	
    driver = new FirefoxDriver();				//创建Firefox类型的Driver，需要电脑提前安装火狐浏览器，建议安装在默认路径。
	baseUrl = "http://cn.bing.com/";          //设置测试的url地址
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //设置全局30秒的默认超时时间
  }

@Test
  public void testBing() throws Exception {
	  try
      {driver.get(baseUrl);						//打开浏览器，访问测试url地址，这里以必应网站搜索为例
      }catch(Exception e){
    	  e.printStackTrace();
    	  driver.get(baseUrl);
      }
	  Thread.sleep(2000);						//最简单的等待方法，强制等待2秒，等待页面加载完成

      driver.findElement(By.id("sb_form_q")).sendKeys("WebDriver");     //搜索输入框id为sb_form_q，在搜索框中输入关键字"WebDriver"
      driver.findElement(By.id("sb_form_go")).click();					//点击"搜索"按钮
  }

@After
  public void tearDown() throws Exception {
      driver.quit();   							//关闭浏览器driver。请确保每次打开driver测试完成后都有及时关闭.
  }
}
