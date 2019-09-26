package apiTestScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.Country;
import restGenericMethod.RestClientMethod;
import testBase.TestBase;

public class RestApiClientTest {
	String url;
	String baseUrl;
	String serviceUrl;
	TestBase testbase;
	ObjectMapper mapper;

	@BeforeMethod
	public void setUp() throws IOException {
		testbase = new TestBase();
		baseUrl = TestBase.prop.getProperty("url");
		serviceUrl = TestBase.prop.getProperty("apiUrl");
		url = baseUrl + serviceUrl;
		mapper = new ObjectMapper();
	}

	@Test(priority = 4, enabled = true)
	public void getCountries() {
		System.out.println("getCountries() started..");
		Response response = RestClientMethod.get(url);
		// String id=response.jsonPath().getString("id");
		// System.out.println(id);
		ResponseBody body = response.getBody();
		System.out.println(body.prettyPrint());
		System.out.println("Status Code :" + response.getStatusCode());
		assertEquals(TestBase.SUCCESS_RESPONSE_CODE_200, response.getStatusCode());

	}

	@Test(enabled = false, priority = 1)
	public void registerCountry() throws JsonProcessingException {
		System.out.println("registerCountry() method started..");
		System.out.println("Post Method Excution statred :");
		Country cObj = new Country(10, "Amrita", "5000");
		// //object to json in string
		String countryjsonString = mapper.writeValueAsString(cObj);
		Response response = RestClientMethod.post(baseUrl, serviceUrl, countryjsonString);
		System.out.println("POST API Response :" + response.getBody().prettyPrint());
		System.out.println("Status Code :" + response.getStatusCode());
		assertEquals(TestBase.SUCCESS_RESPONSE_CODE_200, response.getStatusCode());

	}

	@Test(enabled = false, priority = 2)
	public void getCountryById() {
		System.out.println("getCountryById() started..");
		int id = 5;

		String rspBody = RestAssured.given().pathParam("conId", id).when().get(url + "/{conId}").getBody()
				.prettyPrint();
		System.out.println(rspBody);

	}

	@Test(enabled = false, priority = 1)
	public void modifyCountry() throws JsonProcessingException {
		System.out.println("modifyCountry() started..");
		Country cObj = new Country();
		cObj.setId(5);
		cObj.setCountryName("Abhay");
		cObj.setPopulation("2500");
		String objStr = mapper.writeValueAsString(cObj);
		Response response = RestClientMethod.put(url, objStr);
		System.out.println("PUT API Response :" + response.asString());
		System.out.println(response.getStatusCode());
		assertEquals(TestBase.SUCCESS_RESPONSE_CODE_200, response.getStatusCode());
	}

	@Test(enabled = false, priority = 2)
	public void removeCountry() {
		System.out.println("removeCountry() started..");
		int id = 5;
		Response response = RestClientMethod.delete(url, id);
		System.out.println("DELETE API Response :No Content return " + response.asString());
		System.out.println("Delete method status code :" + response.statusCode());
		assertEquals(TestBase.SUCCESS_RESPONSE_NOCONTENT_204, response.getStatusCode());
	}

}
