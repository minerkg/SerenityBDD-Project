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

    @FindBy( xpath = "/html/body/div[4]/div[4]/div[2]/div[2]/div/div[2]/div/form/div/div[3]/input")
    WebElementFacade loginButton;


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


}
