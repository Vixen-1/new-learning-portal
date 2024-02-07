package effigo.ayushi.newlearningportal.service.impl;

import java.util.List;

import effigo.ayushi.newlearningportal.entity.CourseEntity;

public interface FavoriteServiceImpl {
	List<CourseEntity> seeFavoriteCourse(String username, String password);
}
