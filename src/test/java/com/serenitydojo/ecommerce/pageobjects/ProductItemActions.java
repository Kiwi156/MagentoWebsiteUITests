package com.serenitydojo.ecommerce.pageobjects;

import net.serenitybdd.annotations.Step;

public class ProductItemActions {

    ProductItemPanel productItemPanel;
    ProductDetailsPage productDetails;

   // @Step("Add {0} to the cart")
   // public void addItemToCart(String itemName) {
     //   productItemPanel.selectItem(itemName);
       // productDetails.addToCart();
   // }

    @Step("Add {0} with size {1} and color {2} to the cart")
    public void addItemToCart(String itemName, String size, String color) {
        productItemPanel.selectItem(itemName, size, color);
        productDetails.addToCart();

    }
}