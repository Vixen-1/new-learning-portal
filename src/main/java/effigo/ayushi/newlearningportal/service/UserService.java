package effigo.ayushi.newlearningportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.dto.UserDto;
import effigo.ayushi.newlearningportal.entity.UserEntity;
import effigo.ayushi.newlearningportal.service.UserService;

public interface UserService{
	
	Optional<UserDto> getUserById(Long userId) throws ResponseStatusException;
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(Long userId, UserDto userDto) throws ResponseStatusException;
	
	void deleteUser(Long userId) throws ResponseStatusException;

	List<UserDto> getAllUsers();
}
