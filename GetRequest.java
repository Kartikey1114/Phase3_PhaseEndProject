package phaseEndProject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class GetRequest {

	@Test
	public void getResource()
	{
		RestAssured
		.given()
	    	.contentType("application/json")
	    	.header("Authorization","Bearer 145e739b42d929ecbf1a35bfbd2c1cb0846819d37438650a56d9aeae2249ea2d")
		.when()
			.get("https://gorest.co.in/public/v2/users/4926")
			.then()
			.statusCode(200)
			.log().all()
			.and()
			.body("email", is("batman55332211@gmail.com"));
	}
}

