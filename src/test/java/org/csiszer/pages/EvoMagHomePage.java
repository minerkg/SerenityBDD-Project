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

    @FindBy(css="#personal_header > div.account_header > div.c_header > div.phico.fa.fa-user-o")
    private WebElementFacade loginIcon;

    @FindBy(css = "#personal_header > div.account_header > div.account_head_details > div > a")
    private WebElementFacade loginButton;

    @FindBy(css = "#personal_header > div.account_header > div.account_head_details > div:nth-child(1) > a")
    private WebElementFacade accountDetailsLink;

    @FindBy(id = "searchString")
    private WebElementFacade searchTextBox;

    @FindBy(css = "#top_search > div > div.button_search > input")
    private WebElementFacade searchButton;



    @FindBy(name="go")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}