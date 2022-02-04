package stepDefination;
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

public class Get {

	RequestSpecification request;
	Response response;

	@Given("User is on netbanking landing page")
	public void user_is_on_netbanking_landing_page() {
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
				
	}
	@When("User loging into app using credentials")
	public void user_loging_into_app_using_credentials() {
		System.out.println("When");
		String path="api/users/2";
		response=request.get(path).then().log().all().extract().response();
	}
	@Then("Home is poppulated")
	public void home_is_poppulated() {
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
		Assert.assertEquals(200, response.getStatusCode());
	}
}