package by.sergey.belyakov.dto.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class IssueResponseDto {

	private String summary;
	private String description;
	private String id;
	@JsonProperty("$type")
	private String type;


}
