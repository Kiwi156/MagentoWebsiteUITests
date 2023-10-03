package com.serenitydojo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.Link;

    public class RegisterAccountActions extends UIInteractions {

        @Step("Register a new account for {0} {1} with email {2} and password {3}")
        public void forANewCustomer(String firstname,
                                    String lastName,
                                    String email,
                                    String password) {

            openUrl("https://magento.softwaretestingboard.com/");

            find(Link.withText("Create An Account")).click();

            find(InputField.withLabel("First Name")).type(firstname);
            find(InputField.withLabel("Last Name")).type(lastName);


            find(InputField.withLabel("Email")).type(email);

            find(InputField.withLabel("Password")).type(password);
            find(InputField.withLabel("Confirm Password")).type(password);

            find(Button.withText("Create an Account")).click();

            waitForTextToAppear("Thank you for registering with Main Website Store");
        }
    }


