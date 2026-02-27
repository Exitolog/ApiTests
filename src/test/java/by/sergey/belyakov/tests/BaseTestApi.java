package by.sergey.belyakov.tests;


import by.sergey.belyakov.dto.request.ProjectRequestToCresaateIssueDto;

public class BaseTestApi {

	protected final String baseToken = "perm-YWRtaW4=.NDItMQ==.6pDnSMi1jY2EF389nLIYzy4Ctpr2Ts";
	protected final String baseUrl = "http://localhost:8080";
	protected final ProjectRequestToCresaateIssueDto projectRequestToCresaateIssueDto = new ProjectRequestToCresaateIssueDto("0-0");

}
