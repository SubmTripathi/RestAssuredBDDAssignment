package stepDefination;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Delete {
	
	RequestSpecification request;
	Response response;
	
	@Given("The API is provided")
	public void the_api_is_provided() {
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
				
	}

	@When("The  Credental is entered to delete")
	public void the_credental_is_entered_to_delete() {
		System.out.println("When");
		String path="api/users/2";
		response=request.delete(path).then().log().all().extract().response();
	}

	@Then("Deletion Successfull message of  obtain")
	public void deletion_successfull_message_of_obtain() {
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
		
	}

}
