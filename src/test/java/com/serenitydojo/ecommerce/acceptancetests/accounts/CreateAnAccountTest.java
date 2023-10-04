package com.serenitydojo.ecommerce.acceptancetests.accounts;

import com.serenitydojo.ecommerce.actions.LoginActions;
import com.serenitydojo.ecommerce.actions.NavigationActions;
import com.serenitydojo.ecommerce.actions.RegisterAccountActions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import org.junit.jupiter.api.Test;

public class CreateAnAccountTest extends UIInteractions {

    @Steps
    NavigationActions navigate;

    @Steps
    RegisterAccountActions registerAccount;

    @Steps
    LoginActions login;

    @Test
    void shouldCreateANewCustomerAccount(){

        registerAccount.forANewCustomer("Sarah-Jane", "Smith", randomEmail(), "Secret123");

        waitForTextToAppear("Thank you for registering with Main Website Store");
    }

    @Test
    void shouldBeAbleToLogOnWithARegisteredAccount(){

        String email = randomEmail();

        registerAccount.forANewCustomer("Jo", "Pond", email, "Secret123");

        login.signOut();

        navigate.openTheApplication();
        login.using(email, "Secret123");

        waitForTextToAppear("Welcome, Jo Pond!");

    }

    private String randomEmail() { return System.currentTimeMillis() + "@example.com";}
}
