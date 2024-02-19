package effigo.ayushi.newlearningportal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import effigo.ayushi.newlearningportal.dto.RegisterDto;
import effigo.ayushi.newlearningportal.entity.RegisterEntity;

@Mapper
public interface RegisterPopulator {
	RegisterPopulator INSTANCE = Mappers.getMapper(RegisterPopulator.class);

	//Entity to DTO
	RegisterDto mapToDto(RegisterEntity registerEntity);

	//DTO to Entity
	RegisterEntity mapToEntity(RegisterDto registerDto);
}
