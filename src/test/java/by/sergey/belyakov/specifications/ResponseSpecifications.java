package by.sergey.belyakov.specifications;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;


public class ResponseSpecifications {

	private static final String CONTENT_TYPE = "application/json";

	public static ResponseSpecification baseSpecificationResponseWithStatus200() {
		return new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(CONTENT_TYPE)
				.build();
	}

	public static ResponseSpecification baseSpecificationResponseWithStatus404() {
		return new ResponseSpecBuilder()
				.expectStatusCode(404)
				.expectContentType(CONTENT_TYPE)
				.build();
	}
}
