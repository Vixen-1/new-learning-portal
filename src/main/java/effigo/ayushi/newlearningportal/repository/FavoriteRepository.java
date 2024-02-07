package effigo.ayushi.newlearningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import effigo.ayushi.newlearningportal.entity.FavoriteEntity;
import effigo.ayushi.newlearningportal.entity.UserEntity;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long>{
	List<FavoriteEntity> findByUser(UserEntity userEntity);
}
