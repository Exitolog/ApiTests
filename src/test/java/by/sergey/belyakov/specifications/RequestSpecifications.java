package by.sergey.belyakov.specifications;

import by.sergey.belyakov.dto.request.CreateIssueRequestDto;
import by.sergey.belyakov.utill.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecifications {

	private static final Map<String, String> COMMON_HEADERS = Map.of(
			"Content-Type", "application/json",
			"Accept", "application/json"
	);

	public static RequestSpecification specificationRequestForGetAuthorizationUserInfo() {
		return new RequestSpecBuilder()
				.setBaseUri(ApiConfig.getBaseUrl())
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(ApiConfig.getAuthToken()))
				.addQueryParam("fields", "id,login,name,email")
				.setBasePath("/api/users/me")
				.build();
	}

	public static RequestSpecification specificationRequestForGetAllProjects(){
		return new RequestSpecBuilder()
				.setBaseUri(ApiConfig.getBaseUrl())
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(ApiConfig.getAuthToken()))
				.addQueryParam("fields", "id,name,shortName,createdBy(login,name,id),leader(login,name,id)")
				.setBasePath("/api/admin/projects")
				.build();
	}

	public static RequestSpecification specificationRequestForGetAllIssues(){
		return new RequestSpecBuilder()
				.setBaseUri(ApiConfig.getBaseUrl())
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(ApiConfig.getAuthToken()))
				.addQueryParam("fields", "id,summary,description")
				.setBasePath("/api/issues")
				.build();
	}

	public static RequestSpecification specificationRequestForUsedIssueById(String idNewIssue){
		return new RequestSpecBuilder()
				.setBaseUri(ApiConfig.getBaseUrl())
				.addHeaders(COMMON_HEADERS)
				.setAuth(RestAssured.oauth2(ApiConfig.getAuthToken()))
				.addPathParam("issueID", idNewIssue)
				.addQueryParam("fields", "id,summary,description")
				.setBasePath("/api/issues/{issueID}")
				.build();
	}

	public static RequestSpecification specificationRequestForCreateNewIssue(CreateIssueRequestDto createIssueRequestDto){
		return new RequestSpecBuilder()
				.setBaseUri(ApiConfig.getBaseUrl())
				.addHeaders(COMMON_HEADERS)
				.setBody(createIssueRequestDto)
				.setAuth(RestAssured.oauth2(ApiConfig.getAuthToken()))
				.addQueryParam("fields", "idReadable")
				.setBasePath("/api/issues/")
				.build();
	}
}
