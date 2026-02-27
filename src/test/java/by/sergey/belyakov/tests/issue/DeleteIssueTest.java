package by.sergey.belyakov.tests.issue;

import by.sergey.belyakov.dto.request.CreateIssueRequestDro;
import by.sergey.belyakov.tests.BaseTestApi;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class DeleteIssueTest extends BaseTestApi {

	@Test
	@Description("Создание и удаление задачи с заданными параметрами")
	@Parameters({"header", "description"})
	public void deleteIssue(@Optional("Заголовок такой-то") String baseHeader,
		    				@Optional("Описание такое-то") String baseDescription) {

		CreateIssueRequestDro dto = CreateIssueRequestDro.builder()
				.summary(baseHeader)
				.description(baseDescription)
				.project(projectRequestToCresaateIssueDto)
				.build();

		String idNewIssue = given()
				.contentType(ContentType.JSON)
				.queryParam("fields", "idReadable")
				.body(dto)
				.when().auth().oauth2(baseToken)
				.post(baseUrl + "/api/issues")
				.then()
				.log().ifError()
				.extract().jsonPath().getString("idReadable");

		int status = given()
				.contentType(ContentType.JSON)
				.pathParam("issueID", idNewIssue)
				.when().auth().oauth2(baseToken)
				.delete( baseUrl + "/api/issues/{issueID}")
				.then()
				.log().ifError()
				.extract().response().getStatusCode();

		int statusNotFound = given()
				.pathParam("issueID", idNewIssue)
				.contentType(ContentType.JSON)
				.when().auth().oauth2(baseToken)
				.get( baseUrl + "/api/issues/{issueID}")
				.then()
				.log().ifError()
				.extract().response().getStatusCode();

		assertEquals(status, 200);
		assertEquals(statusNotFound, 404);

	}

}
