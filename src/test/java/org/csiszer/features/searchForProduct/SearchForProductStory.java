package org.csiszer.features.searchForProduct;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.csiszer.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.core.annotation.Order;


@RunWith(SerenityRunner.class)
public class SearchForProductStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUser;

    @Order(3)
    @Issue("#Search-1")
    @Test
    public void searching_for_existing_product_should_display_the_some_products() {
        endUser.is_the_home_page();
        endUser.looks_for("iphone 15 pro");
        endUser.should_see_results_with_the_given_product_name("iPhone");
    }

} 