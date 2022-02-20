package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By dobDay = By.name("DateOfBirthDay");
    private By dobMonth = By.name("DateOfBirthMonth");
    private By dobYear = By.name("DateOfBirthYear");
    private By email = By.id("Email");
    private By companyName = By.id("Company");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerBtn = By.id("register-button");
    private By getRegisterSuccessMessage=By.xpath("//div[@class='result']");
    private By continueBtn=By.xpath("//a[text()='Continue']");

    public HomePage registerNewUser(String gender, String firstName, String lastName,String day,String month,String year,String email,String company,String password){
        if(gender.equalsIgnoreCase("male")){
            elementUtil.doClick(genderMale);
        }else{
            elementUtil.doClick(genderFemale);
        }
        elementUtil.doSendKeys(this.firstName,firstName);
        elementUtil.doSendKeys(this.lastName,lastName);
        elementUtil.doSendKeys(dobDay,day);
        elementUtil.doSendKeys(dobMonth,month);
        elementUtil.doSendKeys(dobYear,year);
        elementUtil.doSendKeys(this.email,elementUtil.randomString(7)+email);
        elementUtil.doSendKeys(companyName,company);
        elementUtil.doSendKeys(this.password,password);
        elementUtil.doSendKeys(confirmPassword,password);
        elementUtil.doClick(registerBtn);
        elementUtil.waitFor(2000);
        elementUtil.doClick(continueBtn);
        elementUtil.waitFor(2000);
        return new HomePage(driver);
    }
}
