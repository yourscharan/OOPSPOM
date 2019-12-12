package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    WebDriver driver;
   public Page page;
   
   @BeforeMethod
   @Parameters({"browser"})
   public void setup(String browser){
       if(browser.equals("chrome")){
	   WebDriverManager.chromedriver().setup(); //bonigracia dependency added so 
	                // we took like this
	   driver=new ChromeDriver();
       }
       else if(browser.equals("ff")){
	   WebDriverManager.firefoxdriver().setup();
	   driver= new FirefoxDriver();
       }
       
       else{
	   System.out.println("no browser is defined inn xml file");
       }
       driver.get("http://apps.qaplanet.in/hrm/login.php");
       
       page=new BasePage(driver);// bcoz Page.java is abstract class and we have to 
                             //call the Page class or its constructor using its child class
                          //so we r using BasePage(childclass)..its like creating an object
                       // but through child class BasePAge..
   }
    
    
   @AfterMethod
   public void teardown(){
       driver.quit();
   }
}
