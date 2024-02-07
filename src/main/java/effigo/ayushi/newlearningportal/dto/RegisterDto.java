package effigo.ayushi.newlearningportal.dto;

import effigo.ayushi.newlearningportal.entity.RegisterEntity;
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
	
	public RegisterDto(RegisterEntity registerEntity) {
		this.id = registerEntity.getId();
		this.user = new UserDto(registerEntity.getUser());
		this.course = new CourseDto(registerEntity.getCourse());
	}
}
