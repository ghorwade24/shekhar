package requersTestCase;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class listToGetUserList {
	public void queryPar(String key,String value) {
	
		given()
		.queryParam(key, value);
		
		
	}
	@Test
	public static void verifyingGet() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log()
		.all();
			
	}
	@Test
	public void verifyingGetSingleUser() {
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.log()
		.all();
	}
	@Test
	public void verifyingGetSingleUserNotFound() {
		given()
		.when()
		.get("https://reqres.in/api/users/234")
		.then()
		.log()
		.all();
	}
	@Test
	public void createDataForNewUserUsingPost() {
		given()
		.when()
		.body("{\r\n"
				+ "    \"name\": \"shekhus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.post("https://reqres.in/api/users")
		.then()
		.log().all();
	}
	public static void main(String[] args) {
		listToGetUserList req = new listToGetUserList();
		req.createDataForNewUserUsingPost();
	}
	
	
}
