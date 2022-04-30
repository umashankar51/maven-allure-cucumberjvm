package stepDefinitions;

import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

public class PostOrderSteps {

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
