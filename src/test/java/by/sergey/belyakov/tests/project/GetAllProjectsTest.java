package by.sergey.belyakov.tests.project;

import by.sergey.belyakov.dto.response.ProjectsResponseDto;
import by.sergey.belyakov.tests.BaseTestApi;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;


public class GetAllProjectsTest extends BaseTestApi {

	@Test
	public void getAllProjects() {

		List<ProjectsResponseDto> list = given()
				.contentType(ContentType.JSON)
				.when()
				.queryParam("fields", "id,name,shortName,createdBy(login,name,id),leader(login,name,id)")
				.auth().oauth2(baseToken)
				.get(baseUrl + "/api/admin/projects")
				.then()
				.log().ifError()
				.extract().jsonPath().getList("", ProjectsResponseDto.class);

		ProjectsResponseDto firstProject = list.getFirst();

		assertFalse(list.isEmpty());
		assertEquals(firstProject.getName(), "Демопроект");
	}
}
