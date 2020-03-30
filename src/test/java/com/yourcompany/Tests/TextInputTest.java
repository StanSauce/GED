package com.yourcompany.Tests;

import com.yourcompany.Pages.GuineaPigPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;


/**
 * Created by Swilliams on 3/30/2020.
 */

public class TextInputTest extends TestBase {

    /**
     * Runs a simple test verifying search function.
     * @throws InvalidElementStateException
     */
    @org.testng.annotations.Test(dataProvider = "hardCodedBrowsers")
    public void verifyCommentInputTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        String emailText = "test@test.test";

        this.annotate("Visiting  page...");
        GuineaPigPage page = GuineaPigPage.visitPage(driver);

        this.annotate("Load Contact Page");
        page.followContactLink();

        this.annotate(String.format("Enter Email: \"%s\"", emailText));
        page.submitEmail(emailText);

        //Assert.assertTrue(page.emailInForm() == emailText);
        Assert.assertEquals(page.emailInForm(), emailText, "Email in Form Element");
    }

}