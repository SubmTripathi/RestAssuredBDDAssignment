package stepDefination;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matcher.*;
import org.hamcrest.Matcher.*;

public class Dmo {

	public static void main(String[] args) {
		RequestSpecification requestSpecification;
		ResponseSpecification responseSpecification = null;
		
		responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(200)
			    .expectStatusLine("HTTP/1.1 200 OK")
			    .build();
		
		requestSpecification = RestAssured.given();
		
		RestAssured.given()
		.spec(requestSpecification)
		.when().get("https://reqres.in/api/users?page=2").then().log().all()
		.spec(responseSpecification);

	}

}
