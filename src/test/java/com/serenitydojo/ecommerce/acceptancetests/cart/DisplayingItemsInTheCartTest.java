package com.serenitydojo.ecommerce.acceptancetests.cart;

import com.serenitydojo.ecommerce.actions.CartActions;
import com.serenitydojo.ecommerce.actions.NavigationActions;
import com.serenitydojo.ecommerce.actions.ProductDetailsActions;
import com.serenitydojo.ecommerce.pageobjects.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class DisplayingItemsInTheCartTest extends UIInteractions {

    @Steps
    NavigationActions navigate;
    @Steps
    CartActions cart;

    @Steps
    ProductItemActions productItem;
    @Steps
    ProductDetailsActions productDetails;

    @Steps
    ShoppingCartComponent shoppingCart;
    @Steps
    ProductItemPanel productItemPanel;
    @Test
    void shouldDisplayNoItemsMessageIfCartIsEmpty(){
        navigate.openTheApplication();

        cart.showCartSummary();

        waitForTextToAppear("You have no items in your shopping cart.");
    }
    @Test
    void shouldBeAbleToAddASingleItemToTheCart() {
        navigate.openTheApplication();

        productItem.addItemToCart("Hero Hoodie", "L", "Gray");

        assertThat(cart.itemsInTheCart()).contains("Hero Hoodie");
    }

    @Test
    void shouldBeAbleToAddAMultipleToTheCart() {

        navigate.openTheApplication();
        productItem.addItemToCart("Hero Hoodie", "L", "Gray");

        navigate.openTheApplication();
        productItem.addItemToCart("Breathe-Easy Tank", "L", "White");

        Assertions.assertThat(cart.itemsInTheCart()).contains("Hero Hoodie", "Breathe-Easy Tank");
    }
    @Test
    void shouldBeAbleToRemoveAnItemFromTheCart() {

        navigate.openTheApplication();
        productItemPanel.selectItem("Breathe-Easy Tank", "L", "White");
        productDetails.addToCart();

        shoppingCart.showCartSummary();

        cart.deleteProduct();
        cart.confirmRemovingItem();

        Assertions.assertThat(cart.itemsInTheCart()).doesNotContain("Breathe-Easy Tank");

    }
}
