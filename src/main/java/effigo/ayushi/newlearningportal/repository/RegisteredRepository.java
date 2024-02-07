package effigo.ayushi.newlearningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import effigo.ayushi.newlearningportal.entity.RegisterEntity;

public interface RegisteredRepository extends JpaRepository<RegisterEntity, Long>{
	
}
