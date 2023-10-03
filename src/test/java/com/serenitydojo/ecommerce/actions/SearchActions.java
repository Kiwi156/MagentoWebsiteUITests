package com.serenitydojo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ui.InputField;
import org.openqa.selenium.Keys;


public class SearchActions extends UIInteractions {

        @Step("Search for {0}")
        public void forProduct(String keyword) {
            find(InputField.withPlaceholder("Search entire store here...")).type(keyword, Keys.ENTER);
        }
    }
