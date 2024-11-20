package org.csiszer.features.addProductToCart;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.csiszer.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.core.annotation.Order;


@UseTestDataFrom("src/test/resources/test_parameters/products.csv")
@RunWith(SerenityParameterizedRunner.class)
public class AddProductToCartStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;

    private String productName;



    @Order(5)
    @Issue("#Add to cart")
    @Test
    public void clicking_to_add_to_cart_button_should_add_one_product_to_cart() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(System.getenv("evomag_ro_user"),
                System.getenv("evomag_ro_pass"));
        endUser.looks_for(productName);
        endUser.add_one_product_to_cart();
        endUser.should_see_the_cart_and_the_product_in_it(productName);
        endUser.delete_one_product_from_cart(productName);
    }

}
