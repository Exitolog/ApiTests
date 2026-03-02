package by.sergey.belyakov.dto.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class IssueResponseDto {

	private String summary;
	private String description;
	private String id;
	@JsonProperty("$type")
	private String type;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("IssuesResponseDto{");
		sb.append("summary='").append(summary).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", id='").append(id).append('\'');
		sb.append(", type='").append(type).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
