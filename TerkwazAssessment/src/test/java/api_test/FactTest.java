package api_test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class FactTest{

	/**
	 * navigate the https://cat-fact.herokuapp.com/facts/random 
	 * with parameter animal_type and amount
	 * then log the response body
	 */
	@Test
	public void logResponseBody() {

		given().queryParam("animal_type", "cat").queryParam("amount", 1)
				.when().get("https://cat-fact.herokuapp.com/facts/random")
				.then().statusCode(200).log()
				.body();

	}
	
	/**
	 * navigate the https://cat-fact.herokuapp.com/facts/random 
	 * with parameter animal_type and amount
	 * then check the text field in not empty
	 */
	@Test
	public void checkTextFieldInResponsIsNotEmpty() {

		given().queryParam("animal_type", "cat").queryParam("amount", 1)
				.when().get("https://cat-fact.herokuapp.com/facts/random")
				.then().statusCode(200).assertThat()
				.body("source.size()", greaterThan(0));
	}
	
}
