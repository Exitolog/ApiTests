package by.sergey.belyakov.tests.project;

import by.sergey.belyakov.dto.response.ProjectResponseDto;
import by.sergey.belyakov.endpoints.ProjectEndpoints;
import by.sergey.belyakov.tests.BaseTestApi;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


public class GetAllProjectsTest extends BaseTestApi {

	@Test
	@Description("Получение всех проектов в системе")
	public void getAllProjects() {
		List<ProjectResponseDto> list = ProjectEndpoints.getAllProjects();
		ProjectResponseDto firstProject = list.stream()
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Список пуст"));
		assertFalse(list.isEmpty());
		assertEquals(firstProject.getName(), "Демопроект");
	}
}
