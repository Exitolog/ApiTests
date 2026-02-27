package by.sergey.belyakov.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateIssueRequestDro {

	private String summary;
	private String description;
	private ProjectRequestToCresaateIssueDto project;
}

