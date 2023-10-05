package com.serenitydojo.ecommerce.actions;

import com.serenitydojo.ecommerce.pageobjects.ShoppingCartComponent;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

import java.util.List;

public class CartActions extends UIInteractions {
    ShoppingCartComponent shoppingCart;

    @Step("Show the shopping cart summary")
    public void showCartSummary() {
        shoppingCart.showCartSummary();
    }
    @Step("View items in the cart")
    public List<String> itemsInTheCart(){
        showCartSummary();
        return shoppingCart.getItems();
    }

    @Step("Select the delete")
    public void deleteProduct() {
        find(By.cssSelector("a.action.delete")).click();
    }

    @Step("Confirm removing an item")
    public void confirmRemovingItem() {
        find(By.cssSelector("button.action-accept")).click();
    }
}
