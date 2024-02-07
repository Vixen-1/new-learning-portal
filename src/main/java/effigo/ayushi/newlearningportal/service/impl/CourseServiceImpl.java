package effigo.ayushi.newlearningportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.repository.CourseRepository;
import effigo.ayushi.newlearningportal.service.CourseService;
import effigo.ayushi.newlearningportal.Mapper.CoursePopulator;
import effigo.ayushi.newlearningportal.dto.CourseDto;
import effigo.ayushi.newlearningportal.entity.CourseEntity;

public class CourseServiceImpl implements CourseService
{
	@Autowired
    private CourseRepository courseRepository;
	
	@Autowired
	private CoursePopulator coursePopulator;

	@Override
    public CourseDto getCourseById(Long courseId) throws ResponseStatusException {
        Optional<CourseEntity> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            return coursePopulator.mapToDto(courseOptional.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User dont exist!");
    }

//    @Override
//    public List<CourseDto> getCoursesByCategory(String category) {
//        List<CourseEntity> courses = courseRepository.findByCategory(category);
//        return courses.stream()
//                      .map(coursePopulator::mapToDto)
//                      .collect(Collectors.toList());
//    }
	@Override
    public CourseDto createCourse(CourseDto courseDto) {
//		if (requestingCourseCategory != CourseCategory.AUTHOR) {
//            throw new AccessDeniedException("Only AUTHOR users can create courses");
//        }
        CourseEntity courseEntity = coursePopulator.mapToEntity(courseDto);
        CourseEntity savedCourse = courseRepository.save(courseEntity);
        return new CourseDto(savedCourse);
    }

	@Override
    public CourseDto updateCourse(Long courseId, CourseDto courseDto) throws ResponseStatusException  {
//		if (requestingCourseCategory != CourseCategory.AUTHOR) {
//            throw new AccessDeniedException("Only AUTHOR users can create courses");
//        }
        Optional<CourseEntity> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            CourseEntity courseEntity = courseOptional.get();
            courseEntity.setTitle(courseDto.getTitle());
            courseEntity.setDescription(courseDto.getDescription());
            courseEntity.setCategory(courseDto.getCategory());
            courseEntity.setPrice(courseDto.getPrice());
            CourseEntity updatedCourse = courseRepository.save(courseEntity);
            return new CourseDto(updatedCourse);
        } 
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER DONT EXIST!");
    }

	@Override
    public void deleteCourse(Long courseId) throws ResponseStatusException {
//		if (requestingCourseCategory != CourseCategory.AUTHOR) {
//            throw new AccessDeniedException("Only AUTHOR users can create courses");
//        }
        if (courseRepository.existsById(courseId)) {
           courseRepository.deleteById(courseId);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER DONT EXIST!");
    }

	@Override
    public List<CourseDto> getAllCourses() {
        List<CourseEntity> coursesEntity = courseRepository.findAll();
        
        return coursesEntity.stream()
        		.map(courseEntity -> coursePopulator.mapToDto(courseEntity))
        		.collect(Collectors.toList());
    }
}
