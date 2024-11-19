package org.csiszer.features.deleteProductFromCart;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.csiszer.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class DeleteProductFromCartStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;



    @Issue("#Delete from cart")
    @Test
    public void deleting_product_should_remove_the_deleted_item_from_the_cart() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(System.getenv("evomag_ro_user"),
                System.getenv("evomag_ro_pass"));
        endUser.looks_for("iphone 15 pro");
        endUser.add_one_product_to_cart();
        endUser.delete_one_product_from_cart("iPhone 15 Pro");
        endUser.should_not_see_the_product_in_the_cart("iPhone 15 Pro");


    }


}
