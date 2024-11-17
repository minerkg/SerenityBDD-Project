package org.csiszer.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

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

    @FindBy(id = "searchString")
    private WebElementFacade searchTextBox;

    @FindBy(css = "#top_search > div > div.button_search > input")
    private WebElementFacade searchButton;



    public void accept_cookies() {
        cookieButton.waitUntilVisible().click();
    }


    public void enter_keywords(String keyword) {
        searchTextBox.type(keyword);
    }

    public void lookup_products() {
        searchButton.click();
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


    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}