package effigo.ayushi.newlearningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import effigo.ayushi.newlearningportal.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByUsername(String username);
}
