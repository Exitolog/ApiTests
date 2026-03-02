package by.sergey.belyakov.tests;


import by.sergey.belyakov.dto.request.CreateIssueRequestDto;
import by.sergey.belyakov.dto.request.ProjectRequestToCreateIssueDto;

public class BaseTestApi {

	private final ProjectRequestToCreateIssueDto projectRequestToCreateIssueDto = new ProjectRequestToCreateIssueDto("0-0");

	protected CreateIssueRequestDto getBaseCreateIssueRequestDto(String header, String description) {
		return CreateIssueRequestDto.builder()
				.summary(header)
				.description(description)
				.project(projectRequestToCreateIssueDto)
				.build();
	}
}
