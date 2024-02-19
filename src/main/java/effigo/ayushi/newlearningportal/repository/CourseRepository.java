package effigo.ayushi.newlearningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import effigo.ayushi.newlearningportal.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	//	@Query("SELECT c FROM CourseEntity c WHERE c.category = :category")
	//	CourseEntity findByCategory(Category category);
}
