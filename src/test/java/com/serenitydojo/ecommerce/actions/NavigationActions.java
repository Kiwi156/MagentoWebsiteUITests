package com.serenitydojo.ecommerce.actions;


import com.serenitydojo.ecommerce.pageobjects.LumaHomePage;
import net.serenitybdd.core.steps.UIInteractions;

public class NavigationActions extends UIInteractions {

    LumaHomePage lumaHomePage;
    public void openTheApplication(){
        lumaHomePage.open();

    }

}
