package effigo.ayushi.newlearningportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.Mapper.RegisterPopulator;
import effigo.ayushi.newlearningportal.dto.RegisterDto;
import effigo.ayushi.newlearningportal.entity.CourseEntity;
import effigo.ayushi.newlearningportal.entity.RegisterEntity;
import effigo.ayushi.newlearningportal.entity.UserEntity;
import effigo.ayushi.newlearningportal.repository.CourseRepository;
import effigo.ayushi.newlearningportal.repository.RegisteredRepository;
import effigo.ayushi.newlearningportal.repository.UserRepository;
import effigo.ayushi.newlearningportal.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{
	@Autowired
	private RegisteredRepository registerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RegisterPopulator registerPopulator;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public RegisterDto regsiterUserToCourse(Long userId, Long courseId) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		Optional<CourseEntity> coursOptional = courseRepository.findById(courseId);
		if(userOptional.isPresent() && coursOptional.isPresent()) {
			UserEntity user = userOptional.get();
			CourseEntity course = coursOptional.get();
			RegisterEntity registerEntity = new RegisterEntity();
			registerEntity.setUser(user);
			registerEntity.setCourse(course);
			RegisterEntity savedEntity = registerRepository.save(registerEntity);
			return new RegisterDto(savedEntity);
			
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User or course not found");
	}

	@Override
	public RegisterDto unregisterUserFromCourse(Long id) {
		if(registerRepository.existsById(id))
		{
			registerRepository.deleteById(id);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found1");
	}

	@Override
	public List<RegisterDto> listAllRegisteredCourses(Long userId) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            Long optionalUserId = user.getId();
            List<RegisterEntity> registrations = registerRepository.findByUser(optionalUserId);
            return registrations.stream()
                    .map(registerEntity -> registerPopulator.mapToDto(registerEntity))
                    .collect(Collectors.toList());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
	}

		
		
}
