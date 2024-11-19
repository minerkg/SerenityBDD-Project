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



    @Issue("#Add to cart")
    @Test
    public void clicking_to_add_to_cart_button_should_add_one_product_to_cart() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(System.getenv("evomag_ro_user"),
                System.getenv("evomag_ro_pass"));
        endUser.looks_for("iphone 15 pro");
        endUser.add_one_product_to_cart();
        endUser.should_see_the_cart_and_the_product_in_it("iPhone 15 Pro");
    }

}
