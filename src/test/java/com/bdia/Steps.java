package com.bdia;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Locale;

public class Steps {
    @Given("I am on loyalty summary page")
    public void iAmOnLoyaltySummaryPage() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given : step 1");

        Faker data = new Faker(new Locale("fr"));
        String username  = data.name().firstName();
        String name = data.name().lastName();
        String mail = data.internet().emailAddress("bdia");



        String myAdress = data.address().streetAddress();
        System.out.println("My adress is: "  + myAdress);
        System.out.println("My firstname is : " + username);
        System.out.println("My name is  : " + name);
        System.out.println("My email adress is  :  " + mail);
    }
    @When("I click to loyalty widget")
    public void iClickToLoyaltyWidget() {
        System.out.println("When : step 2");
    }
    @Then("Loyalties list is displayed")
    public void loyaltiesListIsDisplayed() {
        System.out.println("Then : step 2");
    }
}
