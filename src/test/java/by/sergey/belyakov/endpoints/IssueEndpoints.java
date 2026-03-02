package by.sergey.belyakov.endpoints;

import by.sergey.belyakov.dto.request.CreateIssueRequestDto;
import by.sergey.belyakov.dto.response.IssueResponseDto;
import by.sergey.belyakov.specifications.RequestSpecifications;
import by.sergey.belyakov.specifications.ResponseSpecifications;
import io.qameta.allure.Step;


import java.util.List;

import static io.restassured.RestAssured.given;

public class IssueEndpoints {

	@Step("POST запрос на создание новой задачи")
	public static String createNewIssueAndReturnId(CreateIssueRequestDto dto){
		return given()
				.spec(RequestSpecifications.specificationRequestForCreateNewIssue(dto))
				.when()
				.post("")
				.then()
				.log().ifError()
				.spec(ResponseSpecifications.baseSpecificationResponseWithStatus200())
				.extract().jsonPath().getString("idReadable");
	}

	@Step("GET запрос для успешного получения информации о задачи по ID")
	public static IssueResponseDto getIssueByIdWithStatus200(String idIssue) {
		return given()
				.spec(RequestSpecifications.specificationRequestForUsedIssueById(idIssue))
				.when()
				.get( "").
				then()
				.spec(ResponseSpecifications.baseSpecificationResponseWithStatus200())
				.log().ifError()
				.extract().as(IssueResponseDto.class);
	}

	@Step("GET запрос для получения кода 404 при попытке найти несуществующую задачу по ID")
	public static int get404ByNotExistIssueId(String idIssue) {
		return given()
				.spec(RequestSpecifications.specificationRequestForUsedIssueById(idIssue))
				.when()
				.get( "").
				then()
				.spec(ResponseSpecifications.baseSpecificationResponseWithStatus404())
				.log().ifError()
				.extract().statusCode();
	}

	@Step("GET запрос на получение списка всех задач (без пагинации)")
	public static List<IssueResponseDto> getAllIssues() {
		return given()
				.spec(RequestSpecifications.specificationRequestForGetAllIssues())
				.get("")
				.then()
				.spec(ResponseSpecifications.baseSpecificationResponseWithStatus200())
				.log().ifError()
				.extract().jsonPath().getList("", IssueResponseDto.class);
	}

	@Step("DELETE запрос на удаление задачи по id")
	public static void deleteIssueById(String idIssue) {
				given()
				.when()
				.spec(RequestSpecifications.specificationRequestForUsedIssueById(idIssue))
				.delete( "")
				.then()
				.log().ifError()
				.extract().response();
	}
}
