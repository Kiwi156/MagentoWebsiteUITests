package com.serenitydojo.Formy;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.annotations.Step;



public class FillingInWebFormActions extends UIInteractions {

    @Step("Fill in a new web form for {0} {1} {2}")
    public void forANewCustomer(String FirstName,
                                String LastName,
                                String JobTitle){

    openUrl("https://formy-project.herokuapp.com/form");

    $("#first-name").type(FirstName);

    $("#last-name").type(LastName);

    $("#job-title").type(JobTitle);

    $("#radio-button-2").click();

    $("#checkbox-2").click();

    $("[value='2']").click(); // 2-4 Years of Experience selected.

    $("#datepicker").click(); // Current day will be selected.


    // Maybe the submit should be a seperate method. Stop here and check the data.
       // $("[role='button']").click();


    }

gi}
