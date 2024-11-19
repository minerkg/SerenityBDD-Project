package org.csiszer.features.addProductToCart;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.csiszer.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddProductToCartStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;



    @Issue("#WIKI-1")
    @Test
    public void clicking_to_add_to_cart_button_should_add_one_product_to_cart() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(System.getenv("evomag_ro_user"),
                System.getenv("evomag_ro_pass"));
        endUser.looks_for("iphone 15 pro");
        endUser.add_one_product_to_cart();
        endUser.should_see_the_cart_and_the_product_in_it("iPhone");

    }


    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
//        endUser.is_the_home_page();
//        endUser.looks_for("pear");
//        endUser.should_see_results_with_the_given_product_name("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }
}
