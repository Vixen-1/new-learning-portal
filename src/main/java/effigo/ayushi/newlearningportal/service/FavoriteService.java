package effigo.ayushi.newlearningportal.service;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.dto.FavoriteDto;

public interface FavoriteService {
	
	FavoriteDto addFavorite(Long registerId) throws ResponseStatusException;
	
	FavoriteDto removeFavoriteDto(Long favId) throws ResponseStatusException;
	
	List<FavoriteDto> seeFavoriteCourse(Long userId)throws ResponseStatusException;
}
