package apiAutomation;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIServices {
	@Test
	public static void restAPI() {
		RestAssured.baseURI ="https://demoqa.com/Account/v1"; 
	    RequestSpecification request = RestAssured.given(); 
	    JSONObject requestParams = new JSONObject();
	    requestParams.put("userName", "test_rest");
	    requestParams.put("password", "Testrest@123"); 
	    request.body(requestParams.toString(1));
	    Response response = request.put("/User"); 
	    ResponseBody body = response.getBody();
	    System.out.println(response.getStatusLine());
	    System.out.println(body.asString());
	}
}
