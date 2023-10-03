package com.serenitydojo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.Link;


public class LoginActions extends UIInteractions {

    @Step("Login as {0} with password {1}")
    public void using(String email, String password){
        find(Link.withText("Sign In")).click();
        find(InputField.withLabel("Email")).type(email);
        find(InputField.withLabel("Password")).type(password);
        find(Button.withText("Sign In")).click();

    }

    @Step
    public void signOut() {
        $("[data-action=customer-menu-toggle]").click();
        $(Link.withText("Sign Out")).click();

    }
}

