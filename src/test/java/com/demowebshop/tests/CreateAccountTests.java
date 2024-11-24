package com.demowebshop.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void registrationNewUserPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        clickOnRegistrationLink();
        fillRegistrationForm(new User()
                .setFirstName("Maynard")
                .setLastName("Keenan")
                .setEmail("maynard0000" + i + "@gmail.com")
                .setPassword("Maynard@gmail1234").setConfirmPassword( "Maynard@gmail1234"));
        clickOnRegistrationButton();
        Assert.assertTrue(isContinueButtonPresent());

    }

    @Test
    public void registrationExistedUserNegativeTest(){
        clickOnRegistrationLink();
        fillRegistrationForm(new User()
                .setFirstName("Maynard")
                .setLastName("Keenan")
                .setEmail("maynard00@gmail.com")
                .setPassword("Maynard@gmail1234").setConfirmPassword( "Maynard@gmail1234"));
        clickOnRegistrationButton();
        Assert.assertTrue(isErrorMessagePresent());

    }


}