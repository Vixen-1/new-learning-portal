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
	
	public UserDto(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.password = userEntity.getPassword();
		this.username = userEntity.getUsername();
		this.role = userEntity.getRole();
	}
	
}
