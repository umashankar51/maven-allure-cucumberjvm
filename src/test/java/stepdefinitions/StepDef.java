package stepdefinitions;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.json.JSONObject;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

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
		Allure.step("When Step Test", Status.BROKEN);
		Allure.parameter("TestType", "When");
		Allure.addAttachment("When.txt", "--------When----------");
	}

	@Then("I have a performed ThenTest for {int}")
	public void thenTest(Integer storeNumber) {
		System.out.println("--------"+storeNumber+"----------");
		Allure.parameter("TestType", "Then");
		Allure.addAttachment("Then.txt", "--------Then----------");
		//Assert.fail();
	}

	@Given("Post Service is performed")
	public void postService() {
		try {
			RestAssured.baseURI ="https://restapi.demoqa.com/customer";
			RequestSpecification request = RestAssured.given();

			JSONObject requestParams = new JSONObject();
			requestParams.put("FirstName", Thread.currentThread().getId()); // Cast
			requestParams.put("LastName", "Singh");
			requestParams.put("UserName", "sdimpleuser2dd2011");
			requestParams.put("Password", "password1");

			requestParams.put("Email",  "sample2ee26d9@gmail.com");
			request.body(requestParams.toString());
			Response response = request.post("/register");

			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, "201");
			String successCode = response.jsonPath().get("SuccessCode");
			Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Correct Success code was returned");

		}catch(Exception e){
			System.out.println("Thread: "+Thread.currentThread().getId()+"------> Error : "+e.getMessage());
			Allure.step(Thread.currentThread().getName(), Status.BROKEN);

		}
	}
}
