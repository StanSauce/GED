package com.yourcompany.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuineaPigPage {

    @FindBy(linkText = "Read our response")
    private WebElement theActiveLink;

    @FindBy(id= "Email")
    private WebElement emailBox;


    public WebDriver driver;
    public static String url = "https://www.ge.com/digital";
    public static String contactURL = "https://www.ge.com/digital/lp/sales-contact-me";

    public static GuineaPigPage visitPage(WebDriver driver) {
        GuineaPigPage page = new GuineaPigPage(driver);
        page.visitPage();
        return page;
    }

    public GuineaPigPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void followLink() {
        theActiveLink.click();
    }

    public void followContactLink(){ this.driver.get(contactURL);}

    public void submitEmail(String text) {
        emailBox.sendKeys(text);
      //  submitButton.click();
    }

    public boolean isOnHomePage() {
        String title = "GE Digital | Putting industrial data to work.";
        return driver.getTitle() == title;
    }

    public boolean isOnCovidPage() {
        String title = "Supporting Our Customers in Response to COVID-19 | GE Digital";
        return driver.getTitle() == title;
    }

    public String emailInForm(){
        String inForm = emailBox.getAttribute("value");
        return inForm;
    }
}
