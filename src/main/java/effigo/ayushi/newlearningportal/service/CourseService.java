package effigo.ayushi.newlearningportal.service;

import java.util.List;

import effigo.ayushi.newlearningportal.dto.CourseDto;
import effigo.ayushi.newlearningportal.entity.CourseEntity;

public interface CourseService {

	List<CourseEntity> getAllCourses();

	CourseDto addCourse(CourseDto course);

	void deleteCourse(Long courseId);

	CourseDto updateCourse(CourseDto course);

}
