package by.sergey.belyakov.tests.issue;

import by.sergey.belyakov.dto.response.IssueResponseDto;
import by.sergey.belyakov.endpoints.IssueEndpoints;
import by.sergey.belyakov.tests.BaseTestApi;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class GetAllIssuesTest extends BaseTestApi {

	@Test
	@Description("Получение списка всех задач")
	public void checkYouTrack() {

		List<IssueResponseDto> list = IssueEndpoints.getAllIssues();
		assertFalse(list.isEmpty());
		assertEquals("Issue", list.getFirst().getType());
	}
}
