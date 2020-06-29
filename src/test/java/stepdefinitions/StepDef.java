package stepdefinitions;

//import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

public class StepDef {
	
	@Given("I have a performed GivenTest")
	public void givenTest() {
		System.out.println("--------Given----------");
		Allure.parameter("TestType", "Given");
		Allure.addAttachment("Given.txt", "--------Given----------");
		Allure.issue("DFS-123", "https://github.com/allure-framework/allure-java/pull/360");

	}
	@When("I have a performed WhenTest")
	public void whenTest() {
		System.out.println("--------When----------");
		Allure.step("When Step Test",Status.BROKEN);
		Allure.parameter("TestType", "When");
		Allure.addAttachment("When.txt", "--------When----------");
	}

	@Then("I have a performed ThenTest")
	public void thenTest() {
		System.out.println("--------Then----------");
		Allure.parameter("TestType", "Then");
		Allure.addAttachment("Then.txt", "--------Then----------");
	}

}
