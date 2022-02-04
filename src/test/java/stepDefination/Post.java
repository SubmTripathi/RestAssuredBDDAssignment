package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

import static org.hamcrest.Matcher.*;
import org.hamcrest.Matcher.*;

public class Post {
	RequestSpecification request;
	Response response;
	@Given("API for testing")
	public void api_for_testing() {
		System.out.println("Given");
		RestAssured.baseURI = "https://reqres.in";
		request = given().header("content-type", "application/json")
				.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}");
	   
	}

	@When("Retrive Correct Information")
	public void retrive_correct_information() {
		System.out.println("When");
		String path = "api/users";
		response = request.post(path).then().log().all().extract().response();
	}

	@Then("Vallidate response status code using Assertion")
	public void vallidate_response_status_code_using_assertion() {
		System.out.println("Then");
		System.out.println("response status code : " + response.getStatusCode());
		System.out.println("response status line : " + response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 201 Created", response.getStatusLine());
		Assert.assertEquals(201, response.getStatusCode());
	}
	}

