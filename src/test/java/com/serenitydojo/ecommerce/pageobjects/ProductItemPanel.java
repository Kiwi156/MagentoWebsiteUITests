package com.serenitydojo.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.ui.Image;

public class ProductItemPanel extends PageComponent {

    public void selectItem(String itemName, String size, String color) {
        find(Image.withAltText(itemName)).click();
        findBy(".swatch-option[option-label={0}]", size).click();
        findBy(".swatch-option[option-label={0}]", color).click();
    }
}
