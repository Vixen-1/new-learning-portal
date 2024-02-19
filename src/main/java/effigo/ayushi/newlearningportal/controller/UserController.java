package effigo.ayushi.newlearningportal.controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import effigo.ayushi.newlearningportal.dto.UserDto;
import effigo.ayushi.newlearningportal.entity.UserEntity;
import effigo.ayushi.newlearningportal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	private static final Logger log = (Logger) LoggerFactory.getLogger(CourseController.class);

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public Optional<UserEntity> getUserById(@PathVariable Long id, @RequestHeader Long userId) {
		//finding the user
		Optional<UserEntity> isUser = userService.getUserById(userId);

		//if user exists
		if (isUser.isPresent()) {
			log.info("user found");
			return userService.getUserById(userId);
		}
		return Optional.empty();
	}

	@PostMapping("/create")
	public UserDto createUser(@RequestBody UserDto userDto) {
		log.info("adding user");
		return userService.createUser(userDto);
	}

	@PutMapping("/{userId}")
	public UserDto updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
		log.info("user updated");
		return userService.updateUser(userId, userDto);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		log.info("deleting user", userId);
		userService.deleteUser(userId);
	}

	@GetMapping("/all")
	public List<UserDto> getAllUsers() {
		log.info("showing all users");
		return userService.getAllUsers();
	}

}
