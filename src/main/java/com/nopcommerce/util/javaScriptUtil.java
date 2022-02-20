package com.nopcommerce.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javaScriptUtil {
    WebDriver driver;
    public javaScriptUtil(WebDriver driver){
        this.driver=driver;
    }
    public void flash(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        String bgColor=element.getCssValue("backgroundColor");
        for(int i=0;i<10;i++){
            js.executeScript("arguments[0].setAttribute('style',arguments[1];",element,"background:yellow;border:2px solid red");

        }
    }
}
