package effigo.ayushi.newlearningportal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

	private Long id;
	private UserDto user;
	private CourseDto course;
	
}
