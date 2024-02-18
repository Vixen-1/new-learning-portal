package effigo.ayushi.newlearningportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import effigo.ayushi.newlearningportal.repository.CourseRepository;
import effigo.ayushi.newlearningportal.service.CourseService;
import effigo.ayushi.newlearningportal.Mapper.CoursePopulator;
import effigo.ayushi.newlearningportal.dto.CourseDto;
import effigo.ayushi.newlearningportal.entity.CourseEntity;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDto addCourse(CourseDto course) {
        CourseEntity courseEntity = CoursePopulator.INSTANCE.mapToEntity(course);
        CourseEntity resCourse = courseRepository.save(courseEntity);

        CourseDto resCourseDto = CoursePopulator.INSTANCE.mapToDto(resCourse);
        return resCourseDto;
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public CourseDto updateCourse(CourseDto course) {
        Optional<CourseEntity> existingCourse = courseRepository.findById(course.getId());

        if (existingCourse.isPresent()) {
            CourseEntity updatedCourse = CoursePopulator.INSTANCE.mapToEntity(course);
            CourseEntity changedCourse = courseRepository.save(updatedCourse);
            CourseDto resCourseDto = CoursePopulator.INSTANCE.mapToDto(changedCourse);

            return resCourseDto;
        }

        return null;
    }
}
