package com.serenitydojo.ecommerce.acceptancetests.cart;

import com.serenitydojo.ecommerce.actions.NavigationActions;
import com.serenitydojo.ecommerce.pageobjects.HotSellersComponent;
import com.serenitydojo.ecommerce.pageobjects.LumaHomePage;
import com.serenitydojo.ecommerce.pageobjects.ProductDetailsPage;
import com.serenitydojo.ecommerce.pageobjects.ShoppingCartComponent;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class DisplayingItemsInTheCartTest extends UIInteractions {

    NavigationActions navigate;
    ShoppingCartComponent shoppingCart;

    ProductDetailsPage productDetailsPage;
    HotSellersComponent hotSellersComponent;
    @Test
    void shouldDisplayNoItemsMessageIfCartIsEmpty(){
        navigate.openTheApplication();

        shoppingCart.showCartSummary();

        waitForTextToAppear("You have no items in your shopping cart.");
    }
    @Test
    void shouldBeAbleToAddASingleItemToTheCart() {
        navigate.openTheApplication();

        hotSellersComponent.selectItem("Hero Hoodie", "L", "Gray");

        productDetailsPage.addToCart();

        shoppingCart.showCartSummary();

         List<String> itemInTheCart = shoppingCart.getItems();

         waitForTextToAppear("Hero Hoodie");

         Assertions.assertThat(itemInTheCart).contains("Hero Hoodie");
    }

    @Test
    void shouldBeAbleToAddAMultipleToTheCart() {

        navigate.openTheApplication();
        hotSellersComponent.selectItem("Hero Hoodie", "L", "Gray");
        productDetailsPage.addToCart();

        navigate.openTheApplication();
        hotSellersComponent.selectItem("Breathe-Easy Tank", "L", "White");
        productDetailsPage.addToCart();

        shoppingCart.showCartSummary();

        List<String> itemInTheCart = shoppingCart.getItems();

        Assertions.assertThat(itemInTheCart).contains("Hero Hoodie", "Breathe-Easy Tank");
    }

}
