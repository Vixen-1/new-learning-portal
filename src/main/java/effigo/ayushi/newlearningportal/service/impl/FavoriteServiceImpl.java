package effigo.ayushi.newlearningportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import effigo.ayushi.newlearningportal.Mapper.FavoritePopulator;
import effigo.ayushi.newlearningportal.dto.FavoriteDto;
import effigo.ayushi.newlearningportal.entity.FavoriteEntity;
import effigo.ayushi.newlearningportal.entity.RegisterEntity;
import effigo.ayushi.newlearningportal.entity.UserEntity;
import effigo.ayushi.newlearningportal.repository.FavoriteRepository;
import effigo.ayushi.newlearningportal.repository.RegisteredRepository;
import effigo.ayushi.newlearningportal.repository.UserRepository;
import effigo.ayushi.newlearningportal.service.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Autowired
	private RegisteredRepository registerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FavoritePopulator favoritePopulator;
	
	@Override
	public FavoriteDto addFavorite(Long registerId) throws ResponseStatusException {
		Optional<RegisterEntity> registerOptional = registerRepository.findById(registerId);
		
		if(registerOptional.isPresent()) {
			RegisterEntity registeredUsers = registerOptional.get();
			
			FavoriteEntity favoriteEntity = new FavoriteEntity();
			favoriteEntity.setRegisterEntity(registeredUsers);
			FavoriteEntity savedFavoriteEntity = favoriteRepository.save(favoriteEntity);
			return favoritePopulator.mapToDto(savedFavoriteEntity);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "COURSE IS NOT REGISTERED!!");
	}

	@Override
	public FavoriteDto removeFavoriteDto(Long favId) throws ResponseStatusException {
		if(favoriteRepository.existsById(favId)) {
			favoriteRepository.deleteById(favId);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "COURSE IS NOT FOUND IN FAVORITES!!");
	}

	
	@Override
	public List<FavoriteDto> seeFavoriteCourse(Long userId)throws ResponseStatusException {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		
		if(userOptional.isPresent()) {
			List<FavoriteEntity> favorites = favoriteRepository.findByUserId(userId);
			return favorites.stream().map(favoritePopulator::mapToDto)
            .collect(Collectors.toList());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER NOT FOUND!");
	}
}
