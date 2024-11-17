package org.csiszer.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


@DefaultUrl("https://www.evomag.ro/client/auth")
public class LoginPage extends PageObject {

    @FindBy(id = "LoginClientForm_Email")
    WebElementFacade usernameInputField;

    @FindBy(id = "LoginClientForm_Password")
    WebElementFacade passwordInputField;

    @FindBy( css = "body > div.main_wrap > div.wrap_inside_container.main_body_container > div.full_width_page > div.meniu_principal_centru_new > div > div.container_principal_dr > div > form > div > div:nth-child(3) > input")
    WebElementFacade loginButton;

    @FindBy( className = "generic_error_message")
    WebElementFacade errorMessageDiv;




    public void enter_username(String username) {
        usernameInputField.clear();
        usernameInputField.type(username);
    }

    public void enter_password(String password) {
        passwordInputField.clear();
        passwordInputField.type(password);
    }

    public void click_login() {
        loginButton.click();
    }

    public String getErrorMessage() {
         return  errorMessageDiv.getText();
    }


}
