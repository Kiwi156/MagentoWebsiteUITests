package com.serenitydojo.ecommerce.actions;

import com.serenitydojo.ecommerce.pageobjects.ProductDetailsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

public class ProductDetailsActions extends UIInteractions {

    ProductDetailsPage productDetailsPage;
    public String getProductTitle(){
        return find(".page-title").getText();
    }

    @Step
    public void addToCart() {
        productDetailsPage.addToCart();
    }
}
