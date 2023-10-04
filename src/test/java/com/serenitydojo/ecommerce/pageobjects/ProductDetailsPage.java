package com.serenitydojo.ecommerce.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageObject {

    @FindBy(id = "product-addtocart-button")
    WebElementFacade addToCartButton;

    @FindBy(css = ".loader")
    WebElementFacade spinner;

    public void addToCart(){
        addToCartButton.click();
        spinner.waitUntilNotVisible();
    }
}
