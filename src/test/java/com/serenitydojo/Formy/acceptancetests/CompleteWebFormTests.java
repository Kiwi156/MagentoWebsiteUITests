package com.serenitydojo.Formy.acceptancetests;

import com.serenitydojo.Formy.FillingInWebFormActions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import org.junit.jupiter.api.Test;

public class CompleteWebFormTests extends UIInteractions {

    @Steps
    FillingInWebFormActions fillingInWebForm;

    @Test
    public void shouldEnterDetailsAndSubmitForm() {


        fillingInWebForm.forANewCustomer("Jo",
                "Smith",
                "Software Tester",
                "College",
                "Female",
                2);

        waitForTextToAppear("The form was successfully submitted!");
    }

    @Test
    public void shouldEnterDetailsAndSubmitFormForPersonWithALongName() {

        fillingInWebForm.forANewCustomer("Hubert",
                "Wolfeschlegelsteinhausenbergerorff",
                "Farmer",
                "High School",
                "Male",
                11);

        waitForTextToAppear("The form was successfully submitted!");
    }
}