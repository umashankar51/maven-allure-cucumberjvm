package stepDefinitions;

import io.cucumber.java.en.*;

public class GoogleHomePageSteps {

    @Given("Navigate to HomePage")
    public void navigateToHome(){
        System.out.println("Navigate to HomePage");
    }

    @When("Perform Google Search")
    public void performSearch(){
        System.out.println("Perform Google Search");
    }
}
