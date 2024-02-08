package effigo.ayushi.newlearningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import effigo.ayushi.newlearningportal.entity.RegisterEntity;

public interface RegisteredRepository extends JpaRepository<RegisterEntity, Long>{

	List<RegisterEntity> findByUser(Long optionalUserId);
	
}
