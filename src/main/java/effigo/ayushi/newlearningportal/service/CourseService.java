package effigo.ayushi.newlearningportal.service;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.dto.CourseDto;

public interface CourseService {
	
	CourseDto getCourseById(Long courseId) throws ResponseStatusException;
	
//	List<CourseDto> getCoursesByCategory(String category);
	
	CourseDto createCourse(CourseDto courseDto);
	
	CourseDto updateCourse(Long courseId, CourseDto courseDto) throws ResponseStatusException;
	
	void deleteCourse(Long courseId) throws ResponseStatusException;
	
	List<CourseDto> getAllCourses();
	
}
