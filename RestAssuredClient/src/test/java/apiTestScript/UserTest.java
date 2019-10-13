package apiTestScript;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericMethod.RestClientMethod;
import MyAPIs.Payload;
import MyAPIs.ResourcePath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testBase.TestBase;

/**
 * @author samarendra
 *
 */
public class UserTest extends TestBase {

	public UserTest() throws IOException {
		super(UserTest.class.getName());

	}

	@Test
	public void getAllUser() {

		log.info("Host information" + prop.getProperty("BaseUrl"));
		RestAssured.baseURI = prop.getProperty("BaseUrl");
		Response res = given().get(ResourcePath.get_list_user_path).then().assertThat().statusCode(SUCCESS_RESPONSE_200)
				.and().contentType(ContentType.JSON).and().extract().response();
		log.info("user" + res.prettyPrint());
		JsonPath jp = RestClientMethod.rawToJson(res);
		List<String> emails = jp.get("data.email");
		System.out.println(emails);
	}

	// @Test
	public void AddNewUserAndRetrive() {

		log.info("Host information" + prop.getProperty("BaseUrl"));
		RestAssured.baseURI = prop.getProperty("BaseUrl");
		Response res = given().body(Payload.createUserData()).when().post(ResourcePath.Create_User_Path).then()
				.assertThat().statusCode(SUCCESS_RESPONSE_CREATED_201).and().contentType(ContentType.JSON).and()
				.extract().response();

		log.info(res.prettyPrint());
		// used for identifies json response
		JsonPath jp = RestClientMethod.rawToJson(res);
		String userId = jp.get("id");
		int usrId = Integer.parseInt(userId);
		System.out.println(usrId);
		// Retrive
		Response res1 = given().get(ResourcePath.get_single_user(4)).then().assertThat()
				.statusCode(SUCCESS_RESPONSE_200).and().contentType(ContentType.JSON).and().extract().response();
		log.info("user" + res1.prettyPrint());
	}

}
