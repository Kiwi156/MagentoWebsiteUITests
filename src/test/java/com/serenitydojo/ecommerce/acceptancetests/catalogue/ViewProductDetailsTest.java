package com.serenitydojo.ecommerce.acceptancetests.catalogue;

import com.serenitydojo.ecommerce.actions.CatalogActions;
import com.serenitydojo.ecommerce.actions.NavigationActions;
import com.serenitydojo.ecommerce.actions.ProductDetailsActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class ViewProductDetailsTest {

    NavigationActions navigate;

    ProductDetailsActions ProductDetails;
    CatalogActions fromTheCatalog;
    @Test
    void shouldShowProductDetailsPage(){
        navigate.openTheLumaApplication();

        fromTheCatalog.showProductDetails();

        assertThat(ProductDetails.getProductTitle()).isEqualTo("Fusion Backpack");
    }
}
