package phaseEndProject;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import log4jdemo.BaseTest;

public class PostRequest extends BaseTest {

	public static HashMap<String,String> map=new HashMap<String,String>();
	UUID uuid=UUID.randomUUID();
	
	@BeforeMethod
	public void postData()
	{
		map.put("name", "batman");
		logger.info("Name Added");
		map.put("email", "batman"+uuid+"@gmail.com");
		logger.info("Email Added");
		map.put("gender", "male");
		logger.info("Gender Added");
		map.put("status", "active");
		logger.info("Status Added");
		
		RestAssured.baseURI="https://gorest.co.in/";
		RestAssured.basePath="/public/v2/users";
		logger.info("Payload Created");
		
	}

	@Test
	public void createResource()
	{
		RestAssured
	    .given()
	    .contentType("application/json")
	    .body(map)
	    .header("Authorization","Bearer 145e739b42d929ecbf1a35bfbd2c1cb0846819d37438650a56d9aeae2249ea2d")
	    .when()
	    .post()
	    .then()
	    .statusCode(201)
	    .log().all();
	}
}
