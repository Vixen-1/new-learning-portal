package effigo.ayushi.newlearningportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.dto.FavoriteDto;
import effigo.ayushi.newlearningportal.service.FavoriteService;

@RestController
@RequestMapping("/favourites")
public class FavoriteController {
	private final FavoriteService favoriteService;
	
	
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	  @PostMapping("/{registerId}")
	    public FavoriteDto addFavorite(@PathVariable Long registerId) {
	        try {
	            return favoriteService.addFavorite(registerId);
	        } catch (ResponseStatusException e) {
	            throw e;
	        }
	    }

	    @DeleteMapping("/{favId}")
	    public FavoriteDto removeFavoriteDto(@PathVariable Long favId) {
	        try {
	            return favoriteService.removeFavoriteDto(favId);
	        } catch (ResponseStatusException e) {
	            throw e;
	        }
	    }

	    @GetMapping("/{userId}")
	    public List<FavoriteDto> seeFavoriteCourse(@PathVariable Long userId) {
	        try {
	            return favoriteService.seeFavoriteCourse(userId);
	        } catch (ResponseStatusException e) {
	            throw e;
	        }
	    }
}
