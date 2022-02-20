package com.nopcommerce.tests;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.util.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test(priority = 1)
    public void validatePageTitleTest() {
        Assert.assertEquals(homePage.getPageTitle(), Constants.PAGE_TITLE);
    }

    @Test(priority = 2)
    public void verifyLogoTest() {
        Assert.assertTrue(homePage.verifyLogo());
    }

    @Test(priority = 3)
    public void verifyRegisterLinkTest() {
        Assert.assertTrue(homePage.verifyRegisterLink());
    }

    @Test(priority = 4)
    public void verifyLoginLinkTest() {
        Assert.assertTrue(homePage.verifyLoginLink());
    }
}
