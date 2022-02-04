package stepDefination;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetURLNegativeResponse {
	
	RequestSpecification request;
	Response response;	
	
	@Given("API for testing URL")
	public void api_for_testing_url() {
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
	}

	@When("Get the Correct Information through Provided URL")
	public void get_the_correct_information_through_provided_url() {
		System.out.println("When");
		String path="api/users/23";
		response=request.get(path).then().log().all().extract().response();
	    
	}

	@Then("Get the Negative Scenario using assertion")
	public void get_the_negative_scenario_using_assertion() {
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine());
	Assert.assertEquals(404, response.getStatusCode());
	  
	}

}
