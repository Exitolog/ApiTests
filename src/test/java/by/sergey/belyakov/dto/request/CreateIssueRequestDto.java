package by.sergey.belyakov.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateIssueRequestDto {

	private String summary;
	private String description;
	private ProjectRequestToCreateIssueDto project;
}

