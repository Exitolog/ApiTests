package by.sergey.belyakov.endpoints;

import by.sergey.belyakov.dto.response.UserInfoResponseDto;
import by.sergey.belyakov.specifications.RequestSpecifications;
import by.sergey.belyakov.specifications.ResponseSpecifications;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class AuthorizationUserInfoEndpoints {

	@Step("Отправка GET запроса на получение информации о авторизованном пользователе")
	public static UserInfoResponseDto getAuthorizationUserInfo() {
		 return given()
				.spec(RequestSpecifications.specificationRequestForGetAuthorizationUserInfo())
				.when()
				.get("")
				.then()
				.log().ifError()
				.spec(ResponseSpecifications.baseSpecificationResponseWithStatus200())
				.extract().as(UserInfoResponseDto.class);
	}
}
