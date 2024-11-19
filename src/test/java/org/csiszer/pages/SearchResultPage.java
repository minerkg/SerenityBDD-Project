package org.csiszer.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://www.evomag.ro/?sn.q=")
public class SearchResultPage extends PageObject {

    @FindBy(css = "body > div.main_wrap > div.wrap_inside_container.main_body_container > div > h1")
    WebElementFacade resultTextInscription;

    @FindBy(className = "nice_add_to_cart")
    List<WebElementFacade> addToCartButtons;

    public void add_one_product_to_cart() {
        addToCartButtons.get(0).click();
    }



}
