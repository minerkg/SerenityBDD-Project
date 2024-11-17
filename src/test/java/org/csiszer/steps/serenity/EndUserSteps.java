package org.csiszer.steps.serenity;

import org.csiszer.pages.EvoMagHomePage;
import net.thucydides.core.annotations.Step;
import org.csiszer.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;


public class EndUserSteps {

    LoginPage loginPage;
    EvoMagHomePage evoMagHomePage;


    @Step
    public void enters(String keyword) {
        evoMagHomePage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        evoMagHomePage.lookup_products();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(evoMagHomePage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        evoMagHomePage.open();
        accept_cookies();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
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
    public void should_see_the_home_page() {
        //TODO implement when is good
        assert(true);
    }

    public void should_see_an_error_message() {
        assertThat(loginPage.getErrorMessage(),
                containsString("Nu va puteti autentifica! Adresa de email introdusa este invalida!")
        );

    }
}