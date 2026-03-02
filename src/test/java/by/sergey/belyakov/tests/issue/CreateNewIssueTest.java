package by.sergey.belyakov.tests.issue;

import by.sergey.belyakov.dto.request.CreateIssueRequestDto;
import by.sergey.belyakov.dto.response.IssueResponseDto;
import by.sergey.belyakov.endpoints.IssueEndpoints;
import by.sergey.belyakov.tests.BaseTestApi;
import by.sergey.belyakov.utill.CsvReader;
import by.sergey.belyakov.utill.FilePathList;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class CreateNewIssueTest extends BaseTestApi {

	@DataProvider(name = "IssueInfo", parallel = true)
	public Object[][] dataProviderMethodForIssueInfo() {
		List<List<String>> csvData = CsvReader.getData(FilePathList.ISSUE_INFO_PATH);
		Object[][] data = new Object[csvData.size()][];
		for (int i = 0; i < csvData.size(); i++) {
			List<String> row = csvData.get(i);
			data[i] = row.toArray(new Object[0]);
		}
		return data;
	}

	@Test(dataProvider = "IssueInfo")
	@Description("Создание новой задачи с заданными параметрами")
	public void createNewIssue(String header, String description) {

		CreateIssueRequestDto dto = getBaseCreateIssueRequestDto(header, description);
		String idNewIssue = IssueEndpoints.createNewIssueAndReturnId(dto);
		IssueResponseDto issueResponseDto =  IssueEndpoints.getIssueByIdWithStatus200(idNewIssue);

				assertEquals(header, issueResponseDto.getSummary());
				assertEquals(description, issueResponseDto.getDescription());

	}
}
