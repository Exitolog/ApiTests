package by.sergey.belyakov.tests.issue;

import by.sergey.belyakov.dto.request.CreateIssueRequestDto;
import by.sergey.belyakov.endpoints.IssueEndpoints;
import by.sergey.belyakov.tests.BaseTestApi;
import by.sergey.belyakov.utill.CsvReader;
import by.sergey.belyakov.utill.FilePathList;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class DeleteIssueTest extends BaseTestApi {

	@DataProvider(name = "BaseIssueInfoForDelete", parallel = true)
	public Object[][] dataProviderMethodForBaseCredentialsAuth() {
		List<List<String>> csvData = CsvReader.getData(FilePathList.BASE_ISSUE_INFO_FOR_DELETE_PATH);
		Object[][] data = new Object[csvData.size()][];
		for (int i = 0; i < csvData.size(); i++) {
			List<String> row = csvData.get(i);
			data[i] = row.toArray(new Object[0]);
		}
		return data;
	}


	@Test(dataProvider = "BaseIssueInfoForDelete")
	@Description("Создание и удаление задачи с заданными параметрами")
	public void deleteIssue(String baseHeader, String baseDescription) {

		CreateIssueRequestDto dto = getBaseCreateIssueRequestDto(baseHeader,baseDescription);
		String idNewIssue = IssueEndpoints.createNewIssueAndReturnId(dto);
		IssueEndpoints.deleteIssueById(idNewIssue);
		int statusNotFound = IssueEndpoints.get404ByNotExistIssueId(idNewIssue);
		assertEquals(statusNotFound, 404);

	}

}
