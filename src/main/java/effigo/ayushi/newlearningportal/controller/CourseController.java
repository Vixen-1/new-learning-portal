package effigo.ayushi.newlearningportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import effigo.ayushi.newlearningportal.dto.CourseDto;
import effigo.ayushi.newlearningportal.dto.UserDto;
import effigo.ayushi.newlearningportal.entity.CourseEntity;
import effigo.ayushi.newlearningportal.entity.UserEntity;
import effigo.ayushi.newlearningportal.entity.UserEntity.Role;
import effigo.ayushi.newlearningportal.service.CourseService;
import effigo.ayushi.newlearningportal.service.UserService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private final CourseService courseService;
	private final UserService userService;
	
	public CourseController(CourseService courseService, UserService userService) {
		this.courseService = courseService;
		this.userService = userService;
	}
	
		@GetMapping
		public List<CourseEntity> getAllCourses() {
			return courseService.getAllCourses();
		}

		@PostMapping
		public CourseDto addCourse(@RequestBody CourseDto course, @RequestHeader Long id) {
			Optional<UserDto> author = userService.getUserById(id);

			if (author.isPresent() && (author.get().getRole() == Role.AUTHOR)) {
				return courseService.addCourse(course);
			}
			return new CourseDto();
		}


		@DeleteMapping("{id}")
		public void deleteCourse(@PathVariable Long id, @RequestHeader Long user_Id) {
			Optional<UserDto> isAuthor = userService.getUserById(user_Id);

			if (isAuthor.isPresent() && (isAuthor.get().getRole() == Role.AUTHOR)) {
				courseService.deleteCourse(id);
			}
		}


		@PutMapping
		public CourseDto updateCourse(@RequestBody CourseDto course, @RequestHeader Long user_Id) {
			
			Optional<UserDto> isAuthor = userService.getUserById(user_Id);

			if (isAuthor.isPresent() && (isAuthor.get().getRole() == Role.AUTHOR)) {
				return courseService.updateCourse(course);
			}
			return new CourseDto();
		}
}
