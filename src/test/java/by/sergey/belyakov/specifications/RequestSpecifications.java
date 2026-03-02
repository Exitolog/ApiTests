package by.sergey.belyakov.specifications;

import by.sergey.belyakov.dto.request.CreateIssueRequestDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecifications {

	private static final String BASE_TOKEN = "perm-YWRtaW4=.NDItMQ==.6pDnSMi1jY2EF389nLIYzy4Ctpr2Ts";
	private static final String BASE_URL = "http://localhost:8080/";
	private static final Map<String, String> COMMON_HEADERS = Map.of(
			"Content-Type", "application/json",
			"Accept", "application/json"
	);

	public static RequestSpecification specificationRequestForGetAuthorizationUserInfo() {
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(BASE_TOKEN))
				.addQueryParam("fields", "id,login,name,email")
				.setBasePath("/api/users/me")
				.build();
	}

	public static RequestSpecification specificationRequestForGetAllProjects(){
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(BASE_TOKEN))
				.addQueryParam("fields", "id,name,shortName,createdBy(login,name,id),leader(login,name,id)")
				.setBasePath("/api/admin/projects")
				.build();
	}

	public static RequestSpecification specificationRequestForGetAllIssues(){
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(BASE_TOKEN))
				.addQueryParam("fields", "id,summary,description")
				.setBasePath("/api/issues")
				.build();
	}

	public static RequestSpecification specificationRequestForUsedIssueById(String idNewIssue){
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(BASE_TOKEN))
				.addPathParam("issueID", idNewIssue)
				.addQueryParam("fields", "id,summary,description")
				.setBasePath("/api/issues/{issueID}")
				.build();
	}

	public static RequestSpecification specificationRequestForCreateNewIssue(CreateIssueRequestDto createIssueRequestDto){
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.addHeaders(COMMON_HEADERS)
				.setBody(createIssueRequestDto)
				.setAuth(RestAssured.oauth2(BASE_TOKEN))
				.addQueryParam("fields", "idReadable")
				.setBasePath("/api/issues/")
				.build();
	}
}
