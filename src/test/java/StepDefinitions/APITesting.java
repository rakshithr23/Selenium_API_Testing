package StepDefinitions;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITesting {

	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
	private static Response response;
	private static String jsonString;

	@Given("I set Get service all api endpoint")
	public void i_set_get_service_all_api_endpoint() {
		System.out.println("set api endoint");
		RestAssured.baseURI = BASE_URL;

	}

	@When("I perform a Get service call")
	public void i_perform_a_get_service_call() {
		System.out.println("i_perform_a_get_service_call");
		RequestSpecification request = RestAssured.given();
		response = request.get("/posts");
	}

	@Then("I validate the response code is {int}")
	public void i_validate_the_response_code_is(Integer int1) {
		System.out.println("set api endoint");
		jsonString = response.asString();
//		System.out.println("response ::" + jsonString);
		Assert.assertTrue(int1 == response.getStatusCode());

	}

	@Then("I validate userid are returned and more than {int}")
	public void i_validate_userid_are_returned_and_more_than(Integer int1) {
		System.out.println("=== i_validate_userid_are_returned_and_more_than ==");

		System.out.println("users" + JsonPath.from(jsonString).get("userId"));
		List<Integer> users = JsonPath.from(jsonString).get("userId");
		System.out.println("users " + users);

		Assert.assertTrue(users.size() > int1);

	}
}
