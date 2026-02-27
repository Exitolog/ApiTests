package by.sergey.belyakov.tests.issue;

import by.sergey.belyakov.dto.request.CreateIssueRequestDro;
import by.sergey.belyakov.dto.response.IssuesResponseDto;
import by.sergey.belyakov.tests.BaseTestApi;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class CreateNewIssue extends BaseTestApi {

	@DataProvider(name = "IssueInfo", parallel = true)
	public Object[][] dataProviderMethodForIssueInfo() {
		return new Object[][]{
				{"Первый заголовк ", "Какое-то описание"},
				{"Второй заголовок", "Какое-то описание"},
				{"Третий заголовок", "Какое-то описание"}};
	}

	@Test(dataProvider = "IssueInfo")
	@Description("Создание новой задачи с заданными параметрами")
	public void createNewIssue(String header, String desription) {

		CreateIssueRequestDro dto = CreateIssueRequestDro.builder()
				.summary(header)
				.description(desription)
				.project(projectRequestToCresaateIssueDto)
				.build();

		String idNewIssue = given()
				.contentType(ContentType.JSON)
				.body(dto)
				.queryParam("fields", "idReadable")
				.when()
				.auth().oauth2(baseToken)
				.post(baseUrl + "/api/issues")
				.then()
				.log().ifError()
				.extract().jsonPath().getString("idReadable");

				IssuesResponseDto issuesResponseDto =  given()
				.contentType(ContentType.JSON)
				.when()
				.pathParam("issueID", idNewIssue)
				.queryParam("fields", "id,summary,description")
				.auth().oauth2(baseToken)
				.get( baseUrl + "/api/issues/{issueID}").
				then()
				.log().ifError()
				.extract().as(IssuesResponseDto.class);

				assertEquals(header, issuesResponseDto.getSummary());
				assertEquals(desription, issuesResponseDto.getDescription());

	}
}
