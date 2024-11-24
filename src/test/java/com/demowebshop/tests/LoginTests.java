package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("maynard000@gmail.com").setPassword("Maynard@gmail1234"));
        clickOnLoginButton();
        Assert.assertTrue(isLogOutButtonPresent());

    }



}