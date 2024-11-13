package org.csiszer.features.login;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.csiszer.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



@UseTestDataFrom("src/test/resources/test_parameters/data.csv")
@RunWith(SerenityParameterizedRunner.class)
public class LoginStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    private String userName;
    private String password;

    @Steps
    public EndUserSteps endUser;

    @Issue("#WIKI-1")
    @Test
    public void loggingin_with_valid_data_should_proceed_to_home_page() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(userName, password);
        endUser.should_see_the_home_page();

    }

    @Disabled
    @Test
    public void loggingin_with_invalid_data_should_display_error_message() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(userName, password);
        endUser.should_see_an_error_message();
    }

}
