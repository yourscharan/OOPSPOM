package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
	super(driver);
    }

    private By homelogo = By.xpath("/html/head/title");

    /**
     * @return the homelogo
     */
    public WebElement getHomelogo() {
        return getElement(homelogo);
    }

    
    //page actions
    
    public String gethomepageTitle(){
	return getPageTitle();
    }
    
}
