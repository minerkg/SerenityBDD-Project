package org.csiszer.features.login;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.csiszer.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;


@UseTestDataFrom("src/test/resources/test_parameters/data.csv")
@RunWith(SerenityParameterizedRunner.class)
public class LoginStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Inject
    EnvironmentVariables environmentVariables;

    private String userName;
    private String password;

    @Steps
    public EndUserSteps endUser;

    @Order(2)
    @Issue("#Login")
    @Test
    public void loggingin_with_valid_data_should_proceed_to_home_page() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(System.getenv("evomag_ro_user"),
                System.getenv("evomag_ro_pass"));
        endUser.should_see_the_home_page_and_account_details_should_be_available();


    }
    @Order(1)
    @Test
    public void loggingin_with_invalid_data_should_display_error_message() {
        endUser.is_the_home_page();
        endUser.logging_in_with_credentials(userName, password);
        endUser.should_see_an_error_message();
    }

}
