package com.serenitydojo.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartComponent  extends PageComponent {

    @FindBy(css = ".showcart")
    WebElementFacade showCartItems;

    @FindBy(css = "#mini-cart .product-item-name")
    List<WebElementFacade> items;

    public void showCartSummary() {
        find(".showcart").click();
    }
    public List<String> getItems() {
          return  items.stream().map(item -> item.getText()).collect(Collectors.toList());
    }

}
