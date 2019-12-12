package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
	super(driver);
    }
    
    //page locators:: implementing encapsulation with private modifier
    
    private By username = By.name("txtUserName");
    
    private By password = By.name("txtPassword");
    
    private By loginbtn = By.name("Submit");

    
    //now create getters and setters-->RightClick->Source->Generate getter and setters
    // but we take only getters as of now
    

    /**
     * @return the username
     *//*
    public By getUsername() { 
        return username;
    }

   

    *//**
     * @return the password
     *//*
    public By getPassword() {
        return password;
    }

   

    *//**
     * @return the loginbtn
     *//*
    public By getLoginbtn() {
        return loginbtn;
    }
*/
    
    /**
     * @return the username
     */
    public WebElement getUsername() { //getUsername should return webElement so that we
	                    //we can perform sendkeys and click etc on this particular
	                    //element so we have to take return type as WebElement 
	                    // instead of 'By'(i.e intially after generating 
	                    //getters it is 'By' only  but we  need to change it
	                   // to WebElement.similalrly for all getters also
        return getElement(username);
    }

    /**
     * @return the password
     */
    public WebElement getPassword() {
        return getElement(password);
    }

    /**
     * @return the loginbtn
     */
    public WebElement getLoginbtn() {
        return getElement(loginbtn);
    }
    
    //optional method if we want to write

    public String getLoginPageTitle(){
	return getPageTitle();//getPageTitle is coming from BasePage->Page
    }
   
    
    public HomePage doLogin(String un,String pwd){
	getUsername().sendKeys(un);
	getPassword().sendKeys(pwd);
	getLoginbtn().click();
	
	return getInstance(HomePage.class);
	//after clicking on login button we r landing on homepage
	//so we r returning homepage class using generic method
	//that we created in Page.java
	
    }
   // overloading above doLogin() method (for negative testing without username and Pwd)
    
    public void doLogin(){
  	getUsername().sendKeys("");
  	getPassword().sendKeys("");
  	getLoginbtn().click();
  	    }

}
