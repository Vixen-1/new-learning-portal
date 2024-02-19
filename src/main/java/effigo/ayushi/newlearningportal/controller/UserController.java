package effigo.ayushi.newlearningportal.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import effigo.ayushi.newlearningportal.dto.UserDto;
import effigo.ayushi.newlearningportal.service.UserService;
import effigo.ayushi.newlearningportal.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	private final UserServiceImpl userServiceImpl;
	private static final Logger log = (Logger) LoggerFactory.getLogger(CourseController.class);

	public UserController(UserService userService) {
		this.userService = userService;
		this.userServiceImpl = new UserServiceImpl();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		return new ResponseEntity<>(userServiceImpl.getUserById(id), HttpStatus.OK);
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
