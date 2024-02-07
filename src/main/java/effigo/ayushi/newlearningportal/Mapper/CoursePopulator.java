package effigo.ayushi.newlearningportal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import effigo.ayushi.newlearningportal.dto.CourseDto;
import effigo.ayushi.newlearningportal.entity.CourseEntity;

@Mapper
public interface CoursePopulator {
	CoursePopulator INSTANCE = Mappers.getMapper(CoursePopulator.class);
	
	//Entity to DTO
	CourseDto mapToDto(CourseEntity courseEntity);
	
	//DTO to Entity
	@Mapping(target = "course_id", ignore = true)
	CourseEntity mapToEntity(CourseDto courseDto);
}
