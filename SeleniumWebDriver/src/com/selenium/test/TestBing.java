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
	
    driver = new FirefoxDriver();				//����Firefox���͵�Driver����Ҫ������ǰ��װ�������������鰲װ��Ĭ��·����
	baseUrl = "http://cn.bing.com/";          //���ò��Ե�url��ַ
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //����ȫ��30���Ĭ�ϳ�ʱʱ��
  }

@Test
  public void testBing() throws Exception {
	  try
      {driver.get(baseUrl);						//������������ʲ���url��ַ�������Ա�Ӧ��վ����Ϊ��
      }catch(Exception e){
    	  e.printStackTrace();
    	  driver.get(baseUrl);
      }
	  Thread.sleep(2000);						//��򵥵ĵȴ�������ǿ�Ƶȴ�2�룬�ȴ�ҳ��������

      driver.findElement(By.id("sb_form_q")).sendKeys("WebDriver");     //���������idΪsb_form_q����������������ؼ���"WebDriver"
      driver.findElement(By.id("sb_form_go")).click();					//���"����"��ť
  }

@After
  public void tearDown() throws Exception {
      driver.quit();   							//�ر������driver����ȷ��ÿ�δ�driver������ɺ��м�ʱ�ر�.
  }
}
