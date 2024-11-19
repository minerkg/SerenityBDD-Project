package org.csiszer.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.csiszer.pages.CartPage;
import org.csiszer.pages.EvoMagHomePage;
import org.csiszer.pages.LoginPage;
import org.csiszer.pages.SearchResultPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;


public class EndUserSteps {

    LoginPage loginPage;
    EvoMagHomePage evoMagHomePage;
    SearchResultPage searchResultPage;
    CartPage cartPage;

    @Step
    public void enters(String productName) {
        evoMagHomePage.enter_product_name(productName);
    }

    @Step
    public void starts_search() {
        evoMagHomePage.lookup_products();
    }

    @Step
    public void should_see_results_with_the_given_product_name(String productName) {
        assertThat(evoMagHomePage.getProductNameResults(), hasItem(containsString(productName)));
    }

    @Step
    public void is_the_home_page() {
        evoMagHomePage.open();
        accept_cookies();
    }

    @Step
    public void looks_for(String productName) {
        enters(productName);
        starts_search();
    }

    @Step
    public void accept_cookies() {
        evoMagHomePage.accept_cookies();
    }


    @Step
    public void logging_in_with_credentials(String userName, String password) {
        evoMagHomePage.select_the_login_icon_and_click();
        loginPage.enter_username(userName);
        loginPage.enter_password(password);
        loginPage.click_login();

    }

    @Step
    public void should_see_the_home_page_and_account_details_should_be_available() {
        assertTrue(evoMagHomePage.isAccountDetailsLinkAvailable());
    }


    @Step
    public void should_see_an_error_message() {
        assertThat(loginPage.getErrorMessage(),
                containsString("Nu va puteti autentifica! Adresa de email introdusa este invalida!")
        );

    }

    @Step
    public void add_one_product_to_cart() {
        searchResultPage.add_one_product_to_cart();
    }

    @Step
    public void should_see_the_cart_and_the_product_in_it(String productName) {
        assertThat(cartPage.getCartProductNames(), hasItem(containsString(productName)));
    }
}