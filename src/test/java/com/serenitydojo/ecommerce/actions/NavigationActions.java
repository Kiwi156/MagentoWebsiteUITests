package com.serenitydojo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

public class NavigationActions extends UIInteractions {
    @Step
    public void openTheLumaApplication(){
        openUrl("https://magento.softwaretestingboard.com/");

    }

}
