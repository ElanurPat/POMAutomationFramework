package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.Constants;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        elementUtil=new ElementUtil(driver);
    }
    private By searchPageName=By.xpath("//div[@class='page-title']/h1");
    private By searchField=By.name("q");
    private By searchKeyWords=By.id("q");
    private By advancedSearchCheckbox=By.id("advs");
    private By manufactureDropDown=By.id("mid");
    private By searchBtn=By.xpath("//button[text()='Search']");
    private By categoriesList=By.xpath("//div[@class='side-2']/div[1]/div[2]/ul/li/a");


    public String getSearchPageName(){
        return elementUtil.doGetText(searchPageName);
    }
    public boolean verifyManufactureDropdown(){
        elementUtil.doClick(advancedSearchCheckbox);
        return elementUtil.compareDropDownOption(manufactureDropDown, Constants.MANUFACTURE_DROPDOWN);
    }
    public List<String> getCategoriesItem(){
        List<String> categoryItemName=new ArrayList<>();
        List<WebElement> categoriesListElement=elementUtil.getElements(categoriesList);
        for(WebElement e:categoriesListElement){
            categoryItemName.add(e.getText());
        }
        return categoryItemName;
    }
}
