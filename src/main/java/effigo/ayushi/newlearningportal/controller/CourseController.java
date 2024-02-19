package effigo.ayushi.newlearningportal.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import effigo.ayushi.newlearningportal.dto.CourseDto;
import effigo.ayushi.newlearningportal.dto.UserDto;
import effigo.ayushi.newlearningportal.entity.CourseEntity;
import effigo.ayushi.newlearningportal.service.CourseService;
import effigo.ayushi.newlearningportal.service.UserService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private final CourseService courseService;
	private final UserService userService;
	private static final Logger log = (Logger) LoggerFactory.getLogger(CourseController.class);

	public CourseController(CourseService courseService, UserService userService) {
		this.courseService = courseService;
		this.userService = userService;
	}

	@GetMapping
	public List<CourseEntity> getAllCourses() {
		log.info("Courses retrieved");
		return courseService.getAllCourses();
	}

	@PostMapping
	public CourseDto addCourse(@RequestBody CourseDto course, @RequestHeader Long id) {
		UserDto author = userService.getUserById(id);

		if (author != null) {
			log.info("course added");
			return courseService.addCourse(course);
		}
		return null;
	}

	@PutMapping
	public CourseDto updateCourse(@RequestBody CourseDto course, @RequestHeader Long user_Id) {

		UserDto isAuthor = userService.getUserById(user_Id);

		if (isAuthor != null) {
			log.info("courses updated");
			return courseService.updateCourse(course);
		}
		return new CourseDto();
	}
}
