package effigo.ayushi.newlearningportal.service;

import java.util.List;

import effigo.ayushi.newlearningportal.dto.RegisterDto;

public interface RegisterService {
	RegisterDto regsiterUserToCourse(Long userId, Long courseId);
		
	RegisterDto unregisterUserFromCourse(Long id);
	
	List<RegisterDto> listAllRegisteredCourses(Long userid);
}
