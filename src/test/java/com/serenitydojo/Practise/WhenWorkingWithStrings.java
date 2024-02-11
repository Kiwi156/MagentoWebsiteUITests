package com.serenitydojo.Practise;

import org.junit.jupiter.api.Test;

public class WhenWorkingWithStrings {

    @Test
    public void workingWithStrings() {

        String petsName = " Phoebe ";

        String upperCasePetsName = petsName.toUpperCase();

        System.out.println(upperCasePetsName);

    }

    @Test
    public void workingWithMoreStrings() {

        String petsName = "Phoebe";

        String newPetsName = petsName.replace("Phoebe", "Czar");

        System.out.println(newPetsName);
    }

    @Test
    public void workingWithStringsAgain() {

        String petsName = "Phoebe Beattie  ";

        String havingAPlayWith = petsName.toLowerCase();

        System.out.println(havingAPlayWith);

    }

}