package com.goRestTestCase;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
@Test
public class ToVerifyUpdateeUserwithPatch {
	@Test
	public void UpdateUserWithPatch() {
		given()
		.body("{\r\n"
				+ "  \"id\": 6942236,\r\n"
				+ "  \"name\": \"Hamsini Pandey\",\r\n"
				+ "  \"email\": \"pandeydfdf_hamsinnni@streich.example\",\r\n"
				+ "  \"gender\": \"female\",\r\n"
				+ "  \"status\": \"active\"\r\n"
				+ "}")
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + "bc80a4e6346b72dd1165a9a35f12707e59ec67af6b208a95b1c8f74750e24712") 
		
		.when()
		.patch("https://gorest.co.in/public/v2/users/6942245")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("email", Matchers.equalToIgnoringCase("pandeydfdf_hamsinni@streich.example"));
		
		
	}
	
}
 