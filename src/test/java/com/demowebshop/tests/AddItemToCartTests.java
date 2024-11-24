package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("maynard000@gmail.com").setPassword("Maynard@gmail1234"));
        clickOnLoginButton();
    }

    @Test
    public void isItemAddedToCardTest() {
        clickOnAddToCartButton();
        pause(1000);
        clickOnShoppingCartLink();
        WebElement itemInCart = driver.findElement(By.xpath("//a[@class='product-name' and text()='14.1-inch Laptop']"));
        String item = itemInCart.getText();
        Assert.assertEquals(itemInCart.getText(), "14.1-inch Laptop");

    }

    @AfterMethod
    public void postCondition() {
        clickOnRemoveFromCartCheckbox();
        clickOnUpdateShoppingCartButton();
    }

}
