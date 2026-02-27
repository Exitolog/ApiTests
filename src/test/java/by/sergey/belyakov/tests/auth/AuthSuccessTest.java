package by.sergey.belyakov.tests.auth;

import by.sergey.belyakov.tests.BaseTestApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class AuthSuccessTest extends BaseTestApi {

	@Test
	@Parameters({"login", "name", "id"})
	public void checkAuthSuccess(
			@Optional("admin") String loginTrue,
			@Optional("admin") String nameTrue,
			@Optional("2-1") String idTrue) {

		Response response = given()
				.contentType(ContentType.JSON)
				.when()
				.queryParam("fields", "id,login,name,email")
				.auth().oauth2(baseToken)
				.get(baseUrl + "/api/users/me")
				.then()
				.log().ifError()
				.extract().response();

		String login = response.jsonPath().getString("login");
		String name = response.jsonPath().getString("name");
		String id = response.jsonPath().getString("id");

		assertEquals(loginTrue, login);
		assertEquals(nameTrue, name);
		assertEquals(idTrue, id);
	}
}
