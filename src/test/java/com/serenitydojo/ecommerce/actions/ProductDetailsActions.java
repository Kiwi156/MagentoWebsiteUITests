package com.serenitydojo.ecommerce.actions;

import net.serenitybdd.core.steps.UIInteractions;

public class ProductDetailsActions extends UIInteractions {
    public String getProductTitle(){
        return find(".page-title").getText();
    }
}
