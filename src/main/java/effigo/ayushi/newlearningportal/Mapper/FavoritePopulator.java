package effigo.ayushi.newlearningportal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import effigo.ayushi.newlearningportal.dto.FavoriteDto;
import effigo.ayushi.newlearningportal.entity.FavoriteEntity;

@Mapper
public interface FavoritePopulator {
	FavoritePopulator INSTANCE = Mappers.getMapper(FavoritePopulator.class);

	//Entity to DTO
	FavoriteDto mapToDto(FavoriteEntity registerEntity);

	//DTO to Entity
	FavoriteEntity mapToEntity(FavoriteDto registerDto);
}
