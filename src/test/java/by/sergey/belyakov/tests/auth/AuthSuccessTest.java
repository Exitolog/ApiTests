package by.sergey.belyakov.tests.auth;

import by.sergey.belyakov.dto.response.UserInfoResponseDto;
import by.sergey.belyakov.endpoints.AuthorizationUserInfoEndpoints;
import by.sergey.belyakov.tests.BaseTestApi;
import by.sergey.belyakov.utill.CsvReader;
import by.sergey.belyakov.utill.FilePathList;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class AuthSuccessTest extends BaseTestApi {

	@DataProvider(name = "BaseCredentialAuth", parallel = true)
	public Object[][] dataProviderMethodForBaseCredentialsAuth() {
		List<List<String>> csvData = CsvReader.getData(FilePathList.BASE_CREDENTIALS_AUTH_PATH);
		Object[][] data = new Object[csvData.size()][];
		for (int i = 0; i < csvData.size(); i++) {
			List<String> row = csvData.get(i);
			data[i] = row.toArray(new Object[0]);
		}
		return data;
	}

	@Test(dataProvider = "BaseCredentialAuth")
	@Description("Проверка авторизации пользователя с валидными данными")
	public void checkAuthSuccess(String expectedLogin, String expectedName, String expectedId) {

		UserInfoResponseDto response = AuthorizationUserInfoEndpoints.getAuthorizationUserInfo();

		assertEquals(expectedLogin, response.getLogin());
		assertEquals(expectedName, response.getName());
		assertEquals(expectedId, response.getId());
	}
}
