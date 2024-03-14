package com.serenitydojo.Formy.acceptancetests;

import com.serenitydojo.Formy.FillingInWebFormActions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompleteWebFormTests extends UIInteractions{

    @Steps
    FillingInWebFormActions fillingInWebForm;


    @Test
    void shouldEnterFirstNameLastNameAndJobTitle(){

        fillingInWebForm.forANewCustomer("Jo",
                                         "Smith",
                                         "Software Tester");

    }

}
