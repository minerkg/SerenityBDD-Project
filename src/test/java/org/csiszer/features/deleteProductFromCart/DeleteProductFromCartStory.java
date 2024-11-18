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



//    @Issue("#WIKI-1")
//    @Test
//    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
//        endUser.is_the_home_page();
//        endUser.looks_for("apple");
//        endUser.should_see_results_with_the_given_product_name("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");
//
//    }
//
//    @Test
//    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
//        endUser.is_the_home_page();
//        endUser.looks_for("pear");
//        endUser.should_see_results_with_the_given_product_name("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
//    }
}
