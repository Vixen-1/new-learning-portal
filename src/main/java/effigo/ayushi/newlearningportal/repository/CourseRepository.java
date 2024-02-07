package effigo.ayushi.newlearningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import effigo.ayushi.newlearningportal.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	CourseEntity findByCategory(String Category);
}
