package effigo.ayushi.newlearningportal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import effigo.ayushi.newlearningportal.dto.UserDto;
import effigo.ayushi.newlearningportal.entity.UserEntity;

@Mapper
public interface UserPopulator {
	UserPopulator INSTANCE = Mappers.getMapper(UserPopulator.class);
	
	//DTO to Entity
	@Mapping(target = "user_id", ignore = true)
	UserEntity populateUser(UserDto userDto);

	//Entity to DTO
	UserDto mapToDto(UserEntity userEntity);
	
}
