package effigo.ayushi.newlearningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import effigo.ayushi.newlearningportal.entity.FavoriteEntity;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long>{
	@Query
//	("SELECT * FROM FavoriteEntity R WHERE R.RegisteredEntity.Registered");
	List<FavoriteEntity> findByUserId(Long userId);
}
