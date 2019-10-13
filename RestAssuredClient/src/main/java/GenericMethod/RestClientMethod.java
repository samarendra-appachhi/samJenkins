package GenericMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


/**
 * @author samarendra
 *
 */
public class RestClientMethod {

	public static Response get(String url) {
		Response rsp = RestAssured.get(url);

		return rsp;
	}

	public static Response post(String baseUrl, String serviceUrl, String strObj) {
		Response rsp = RestAssured.given().baseUri(baseUrl).when().contentType(ContentType.JSON).body(strObj)
				.post(serviceUrl);
		return rsp;
	}

	public static Response put(String url, String strObj) {
		Response rsp = RestAssured.given().when().contentType(ContentType.JSON).body(strObj).put(url);
		return rsp;
	}

	public static Response delete(String url, int id) {
		Response response = RestAssured.given().pathParam("conId", id).when().delete(url + "/{conId}").andReturn();
		return response;
	}

	public static XmlPath rawToXML(Response r) {

		String respon = r.asString();
		XmlPath x = new XmlPath(respon);
		return x;

	}

	public static JsonPath rawToJson(Response r) {
		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
		System.out.println(respon);
		return x;
	}

}
