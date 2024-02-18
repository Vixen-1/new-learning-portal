package effigo.ayushi.newlearningportal.dto;

import effigo.ayushi.newlearningportal.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	private String username;
	private String password;
	private UserEntity.Role role;
	
	
}
