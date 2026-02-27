package by.sergey.belyakov.tests.issue;

import by.sergey.belyakov.dto.response.IssuesResponseDto;
import by.sergey.belyakov.tests.BaseTestApi;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class GetAllIssuesTest extends BaseTestApi {

	@Test
	public void checkYouTrack() {

		List<IssuesResponseDto> list = given()
				.contentType(ContentType.JSON)
				.when().auth().oauth2(baseToken)
				.queryParam("fields", "id,summary,description")
				.get(baseUrl + "/api/issues")
				.then()
				.log().ifError()
				.extract().jsonPath().getList("", IssuesResponseDto.class);

		assertFalse(list.isEmpty());
		assertEquals("Issue", list.getFirst().getType());
	}
}
