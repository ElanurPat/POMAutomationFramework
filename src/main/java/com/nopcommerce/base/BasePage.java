package com.nopcommerce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public Properties prop;
    public static String highlight;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();


    public WebDriver init_driver(String browser) {
        highlight=prop.getProperty("highlight");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            // driver = new ChromeDriver();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            //driver = new FirefoxDriver();


            // return driver;
            tlDriver.set(new FirefoxDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();
    }




        public static synchronized WebDriver getDriver () {
            return tlDriver.get();
        }
        public Properties init_prop () {
            prop = new Properties();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("./src/main/java/com/nopcommerce/config/config.properties");
                prop.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prop;
        }
        public String getScreenshot () {
            File scr = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
            File destination = new File(path);
            try {
                FileUtils.copyFile(scr, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        }
    }

