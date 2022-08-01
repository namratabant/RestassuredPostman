package restApi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void test() {
		// to create object
	RestAssured.baseURI= "http://localhost:3000/employees";

		// to create request
		//given is a method which builds rest specification object given will return Requestspecification
	RequestSpecification request =RestAssured.given();
		//specify the method put,get etc
		Response response =request.get();
		String Responsebody = response.getBody().asString();
		System.out.println(Responsebody);
		//to get responsecode
		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 200);
		
		//to print names
		JsonPath jpath = response.jsonPath();
		List<String>names =jpath.get("name");
		
		
	        
	        System.out.println(names);
	     


}

}