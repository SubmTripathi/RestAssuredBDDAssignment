package stepDefination;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostNegativeResponse {
	
	RequestSpecification request;
	Response response;
	
	@Given("API for POST testing")
	public void api_for_put_testing() {
		System.out.println("Given");
		RestAssured.baseURI = "https://reqres.in";
		request = given().header("content-type", "application/json")
				.body("{\r\n"
						+ "    \"email\": \"peter@klaven\"\r\n"
						+ "}");
	
	}
	    

	@When("Update the Correct Information")
	public void update_the_correct_information() {
		System.out.println("When");
		String path = "api/login";
		response = request.post(path).then().log().all().extract().response();
	    
	}

	@Then("Script for Negative Senario and Vallidate response status")
	public void script_for_negative_senario_and_vallidate_response_status() {
		System.out.println("Then");
		System.out.println("response status code : " + response.getStatusCode());
		System.out.println("response status line : " + response.getStatusLine());   
		Assert.assertEquals("HTTP/1.1 400 Bad Request", response.getStatusLine());
		Assert.assertEquals(400, response.getStatusCode());
	}
}
