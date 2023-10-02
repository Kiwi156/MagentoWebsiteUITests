package com.serenitydojo.ecommerce.acceptancetests.navigation;

import com.serenitydojo.ecommerce.actions.HomePageActions;
import com.serenitydojo.ecommerce.actions.MenuBarActions;
import com.serenitydojo.ecommerce.actions.NavigationActions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.OpenUrl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
class MenuBarTest extends UIInteractions {

    @Steps
    NavigationActions navigate;

    @Steps
    MenuBarActions menuBar;

    @Steps
    HomePageActions homePage;

    @Test
        void shouldDisplayTheCorrectTitle(){
            navigate.openTheLumaApplication();

            Assertions.assertThat(homePage.getTitle()).isEqualTo("Home Page");
        }
       @Test
       void shouldShowTheTopLevelMenuItemsOnTheHomePage(){
           navigate.openTheLumaApplication();

           Assertions.assertThat(menuBar.topLevelMenuItems())
                   .contains("What's New", "Women", "Men", "Training", "Sale");
       }
}
