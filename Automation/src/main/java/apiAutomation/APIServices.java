package apiAutomation;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.beust.jcommander.Strings;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIServices {
	@Test
	public static void restAPI() {
		Response response;
	    response=executeAPI("https://reqres.in/","application/json",false,"get","/api/users?page=2",null);
	    System.out.println(response.getStatusCode());
	    //String responseStr = ((RestAssuredResponseImpl)) response).getBody().toString;
	    System.out.println(response.getBody().asPrettyString());
	    System.out.println(getValueFromJson(response,"data","email"));
	    System.out.println(getValueFromJsonForGivenPair(response,"data","email","id","8"));	
	    System.out.println(getValueFromJson(response,"total"));
	    System.out.println(getValueFromJson(response,"support.url"));
	}
	/*
	 * apiEndPoint = "https://demoqa.com"
	 * contentType = "application/json" or "text/xml"
	 * isAuthReq = true or false
	 * methodName = get,post,put,delete
	 * apiBasePath = "/Account/v1"
	 * request=body
	 */
	public static Response executeAPI(String apiEndPoint,String contentType,boolean isAuthReq
		,String methodName,String apiBasePath,String request) {
		Response response;
		RequestSpecification requestSpecification = RestAssured.given();
		if(isAuthReq)
			requestSpecification=requestSpecification.header("Authorization","Authentication value");
		if(!Strings.isStringEmpty(request))
			requestSpecification=requestSpecification.and().body(request).when();
		if(methodName.equalsIgnoreCase("post"))
			response=requestSpecification.baseUri(apiEndPoint)
			.when()
			.post(apiBasePath)
			.then()
			.extract()
			.response();
		else if(methodName.equalsIgnoreCase("put"))
			response=requestSpecification.baseUri(apiEndPoint)
			.when()
			.put(apiBasePath)
			.then()
			.extract()
			.response();
		else if(methodName.equalsIgnoreCase("delete"))
			response=requestSpecification.baseUri(apiEndPoint)
			.when()
			.delete(apiBasePath)
			.then()
			.extract()
			.response();
		else
			response=requestSpecification.baseUri(apiEndPoint)
			.when()
			.get(apiBasePath)
			.then()
			.extract()
			.response();
		
		return response;
		
	}
	
	public static String getValueFromJson(Response response,String fetchKey,String fetchSubKey)  {
		JSONObject obj = new JSONObject(response.asString());
		JSONArray jsonarray = obj.getJSONArray(fetchKey);
		String value="";
		for(int i=0;i<jsonarray.length();i++) {
			JSONObject jsonObject = jsonarray.getJSONObject(i);
			if(!jsonObject.get(fetchSubKey).toString().isBlank()) {
				value=jsonObject.get(fetchSubKey).toString();
				break;
			}
		}
		return value;
}
	
	public static String getValueFromJsonForGivenPair(Response response,String fetchKey,String fetchSubKey,String forKey,String forValue)  {
		JSONObject obj = new JSONObject(response.asString());
		JSONArray jsonarray = obj.getJSONArray(fetchKey);
		String value="";
		for(int i=0;i<jsonarray.length();i++) {
			JSONObject jsonObject = jsonarray.getJSONObject(i);
			if(jsonObject.get(forKey).toString().equalsIgnoreCase(forValue)) {
				value=jsonObject.get(fetchSubKey).toString();
				break;
			}
		}
		return value;
}
	public static String getValueFromJson(Response response,String fetchKey)  {
		JSONObject obj = new JSONObject(response.asString());
		String key=obj.get(fetchKey).toString();
		return key;
}
}

