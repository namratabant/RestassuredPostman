package github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class EndToEndTest {
	
	

	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://api.github.com/users/namratabant/repos";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		String ResponseBody = response.getBody().asString();
		
		System.out.println(ResponseBody);
		
		int ResponseCode = response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 200);
	}
	
	
	@Test
	public void test2() throws IOException {
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		
		byte[] dataBytes = Files.readAllBytes(Paths.get("data.json"));//data from postman in data.json
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.auth()
                					.oauth2("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")     //tokenvalue from postman-github-variable-tokenvalue
                					.contentType(ContentType.JSON)
									.accept(ContentType.JSON)	
									.body(dataBytes)
									.post();
		
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 401);
	}

}



