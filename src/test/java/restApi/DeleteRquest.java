package restApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRquest {
	@Test
	public void test1() {
		
		
		RestAssured.baseURI= "http://localhost:3000/employees";

		// to create request
		//given is a method which builds rest specification object given will return Requestspecification
	RequestSpecification request =RestAssured.given();
		//specify the method put,get etc
		Response response =request.delete("/3");
		String Responsebody = response.getBody().asString();
		System.out.println(Responsebody);
		//to get responsecode
		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 200);
		
		

}
}
