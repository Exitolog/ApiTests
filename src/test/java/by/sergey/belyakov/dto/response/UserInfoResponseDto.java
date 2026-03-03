package by.sergey.belyakov.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponseDto {

	private String login;
	private String name;
	private String id;

}
