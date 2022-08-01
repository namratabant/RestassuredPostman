package restApi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {
	@Test
	public void test() {
		
	RestAssured.baseURI= "http://localhost:3000/employees";

	RequestSpecification request =RestAssured.given();
		
	Response response =request.param("id", "1").get();
		String Responsebody = response.getBody().asString();
		System.out.println(Responsebody);
		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 200);
		Assert.assertTrue(Responsebody.contains("Pankaj"));
		//to get single name 
		JsonPath jpath = response.jsonPath();
		List<String>names =jpath.get("name");
		System.out.println(names.get(0));
		Assert.assertEquals(names.get(0), "Pankaj");
		 //to get header
		String Header = response.getHeader("Content-Type");
		System.out.println(Header);

		
}

}
