package org.csiszer.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DefaultUrl("https://www.evomag.ro/")
public class EvoMagHomePage extends PageObject {


    @FindBy(id = "ez-cookie-notification__accept")
    private WebElementFacade cookieButton;

    @FindBy(css = "#personal_header > div.account_header > div.c_header > div.phico.fa.fa-user-o")
    private WebElementFacade loginIcon;

    @FindBy(css = "#personal_header > div.account_header > div.account_head_details > div > a")
    private WebElementFacade loginButton;

    @FindBy(css = "#personal_header > div.account_header > div.account_head_details > div:nth-child(1) > a")
    private WebElementFacade accountDetailsLink;

    @FindBy(className = "sn-suggest-input")
    private WebElementFacade searchTextBox;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div[1]/form/div/div[1]/input")
    private WebElementFacade searchButton;

    @FindBy(className = "npi_name")
    private List<WebElementFacade> productSearchResults;



    public void accept_cookies() {
        cookieButton.waitUntilVisible().click();
    }


    public void enter_product_name(String productName) {
        searchTextBox.waitUntilEnabled();
        searchTextBox.clear();
        searchTextBox.type(productName);

    }

    public void lookup_products() {
        withAction().sendKeys(Keys.ENTER).perform();

    }

    public void select_the_login_icon_and_click() {
        loginIcon.click();
        loginButton.click();
    }


    public void navigate_to_account_details() {
        loginIcon.click();
        accountDetailsLink.click();
    }

    public boolean isAccountDetailsLinkAvailable() {
        loginIcon.click();
        return accountDetailsLink.isDisplayed();
    }


    public List<String> getProductNameResults() {
        return productSearchResults.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}