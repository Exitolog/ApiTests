package by.sergey.belyakov.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectResponseDto {

	private String shortName;
	private String createdBy;
	private String name;
	private String id;
	@JsonProperty("$type")
	private String type;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ProjectsResponseDto{");
		sb.append("shortName='").append(shortName).append('\'');
		sb.append(", createdBy='").append(createdBy).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", id='").append(id).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
