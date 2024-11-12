package org.csiszer.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.evomag.ro/?sn.q=")
public class SearchResultPage {

    @FindBy(css = "body > div.main_wrap > div.wrap_inside_container.main_body_container > div > h1")
    WebElementFacade resultTextInscription;



}
