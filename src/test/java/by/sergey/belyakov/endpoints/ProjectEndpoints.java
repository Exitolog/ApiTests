package by.sergey.belyakov.endpoints;

import by.sergey.belyakov.dto.response.ProjectResponseDto;
import by.sergey.belyakov.specifications.RequestSpecifications;
import by.sergey.belyakov.specifications.ResponseSpecifications;
import io.qameta.allure.Step;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectEndpoints {

	@Step("GET запрос для получения всех проектов")
	public static List<ProjectResponseDto> getAllProjects() {
		return 	given().
				spec(RequestSpecifications.specificationRequestForGetAllProjects()).
				when().
				get("").
				then().
				log().ifError().
				spec(ResponseSpecifications.baseSpecificationResponseWithStatus200()).
				extract().jsonPath().getList("", ProjectResponseDto.class);
	}
}
