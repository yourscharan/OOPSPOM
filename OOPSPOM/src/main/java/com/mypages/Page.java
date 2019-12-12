package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    
    WebDriver driver;
    WebDriverWait wait;
    public Page(WebDriver driver){ //constructor
	this.driver=driver;
	this.wait=new WebDriverWait(driver, 30);
    }
    
    //abstract methods---Every page should have these methds
    
    public abstract String getPageTitle();
    
    public abstract String getPageHeader(By locator);
    
    public abstract WebElement getElement(By locator); //this method will return
                                  // a webelement so return type is webelement
    public  abstract void waitForElementPresent(By locator);
    
    public abstract void waitForPageTitle(String Title);
    
    
    //we can take non abstract methods in this abstract class
    
    public <Tpage extends BasePage> Tpage getInstance(Class<Tpage> pageClass){
	try{
	return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
	}catch(Exception e){
	    e.printStackTrace();
	   return null;
	}

    } 
}
