package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class loginTest extends BaseTest {
    
    @Test(priority=1)
    public void verifyLoginPageTitleTest(){
	String title=page.getInstance(LoginPage.class).getLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
    }
    
    @Test(priority=2)
    public void doLoginTest(){
	//page.getInstance(LoginPage.class).doLogin("qaplanet1","lab1");
	//or
	//doLogin is returning homepage so we r assinging hompeage refrnce
	HomePage homepage=page.getInstance(LoginPage.class).doLogin("qaplanet1", "lab1");
	String homeheader=homepage.gethomepageTitle();
	System.out.println(homeheader);
	Assert.assertEquals(homeheader, "OrangeHRM");
    }
    

}
