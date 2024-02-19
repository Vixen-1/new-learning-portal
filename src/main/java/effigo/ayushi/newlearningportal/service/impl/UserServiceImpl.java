package effigo.ayushi.newlearningportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.Mapper.UserPopulator;
import effigo.ayushi.newlearningportal.dto.UserDto;
import effigo.ayushi.newlearningportal.entity.UserEntity;
import effigo.ayushi.newlearningportal.repository.UserRepository;
import effigo.ayushi.newlearningportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPopulator userPopulator;

	@Override
	public UserDto getUserById(Long userId) throws ResponseStatusException {
		Optional<UserEntity> userOptional = userRepository.findById(userId);

		if (userOptional.isPresent()) {
			return (userPopulator.mapToDto(userOptional.get()));
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found with id : " + userId);

	}

	@Override
	public UserDto createUser(UserDto userDto) {
		UserEntity userEntity = userPopulator.populateUser(userDto);
		userRepository.save(userEntity);
		return userDto;
	}

	@Override
	public UserDto updateUser(Long userId, UserDto userDto) throws ResponseStatusException {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			UserEntity userEntity = userOptional.get();
			userEntity.setUsername(userDto.getUsername());
			userEntity.setPassword(userDto.getPassword());
			userEntity.setRole(userDto.getRole());
			userRepository.save(userEntity);
			return userDto;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER DOES NOT EXIST!!");
		}
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserEntity> usersEntity = userRepository.findAll();
		return usersEntity.stream().map(userEntity -> userPopulator.mapToDto(userEntity)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Long userId) throws ResponseStatusException {

		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER WITH ID " + userId + " DOES NOT EXIST!");
		}
	}

}
