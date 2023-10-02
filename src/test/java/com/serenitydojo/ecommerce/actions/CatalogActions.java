package com.serenitydojo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ui.Link;
import org.openqa.selenium.By;


public class CatalogActions extends UIInteractions {

    @Step
    public void showProductDetails(){
        find(By.linkText("Fusion Backpack")).click();

    }

}
