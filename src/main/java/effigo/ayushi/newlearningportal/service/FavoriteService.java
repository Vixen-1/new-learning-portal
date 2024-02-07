package effigo.ayushi.newlearningportal.service;

import java.util.List;

import effigo.ayushi.newlearningportal.entity.CourseEntity;

public interface FavoriteService {
	List<CourseEntity> seeFavoriteCourse(String username, String password);
}
