package effigo.ayushi.newlearningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.dto.RegisterDto;
import effigo.ayushi.newlearningportal.service.RegisterService;


@RestController
@RequestMapping("/registers")
public class RegisterController {
	 private final RegisterService registerService;

	    @Autowired
	    public RegisterController(RegisterService registerService) {
	        this.registerService = registerService;
	    }

	    @PostMapping("/{userId}/{courseId}")
	    public RegisterDto registerUserToCourse(@PathVariable Long userId, @PathVariable Long courseId) {
	        try {
	            return registerService.regsiterUserToCourse(userId, courseId);
	        } catch (ResponseStatusException e) {
	            throw e;
	        }
	    }

	    @DeleteMapping("/{id}")
	    public RegisterDto unregisterUserFromCourse(@PathVariable Long id) {
	        try {
	            return registerService.unregisterUserFromCourse(id);
	        } catch (ResponseStatusException e) {
	            throw e;
	        }
	    }

	    @GetMapping("/{userId}")
	    public List<RegisterDto> listAllRegisteredCourses(@PathVariable Long userId) {
	        try {
	            return registerService.listAllRegisteredCourses(userId);
	        } catch (ResponseStatusException e) {
	            throw e;
	        }
	    }
}
