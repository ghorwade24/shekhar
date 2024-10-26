package requersTestCase;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
public class queryParameterAndPathParameter {
	@Test
	public void queryParameterEx() {
		given()
		.queryParam("page", "2")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("data[0].email", Matchers.equalToIgnoringCase("michael.lawson@reqres.in"));
		
		
	}
	@Test
	public void pathParametr() {
		given()
		.pathParam("id", "2")
		.when()
		.get("https://reqres.in/api/users/{id}")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		;
	}
}
