package com.serenitydojo.ecommerce.acceptancetests.catalogue;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.ui.Image;

@ExtendWith(SerenityJUnit5Extension.class)
class DisplayProductTest extends UIInteractions {
    @Test
    void shouldBeAbleToShowTheProductDetailsPageFromTheCatalog(){
        openUrl("https://magento.softwaretestingboard.com/");

//       find(By.linkText("Hero Hoodie")).click();
//       find(Link.withText("Hero Hoodie")).click();

        find(Image.withAltText("Hero Hoodie")).shouldBeVisible();
        find(Image.withAltText("Hero Hoodie")).click();

        String productTitle = find(By.className("page-title")).getText();
        Assertions.assertThat(productTitle).isEqualTo("Hero Hoodie");
    }
    @Test
    void shouldShowPromoCollectionDetails() {
        openUrl("https://magento.softwaretestingboard.com/");

        find(By.partialLinkText("New Luma Yoga Collection")).click();

        String productTitle = find(By.className("page-title")).getText();
        Assertions.assertThat(productTitle).isEqualTo("New Luma Yoga Collection");

    }
}


