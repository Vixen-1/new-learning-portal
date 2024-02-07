package effigo.ayushi.newlearningportal.dto;

import java.util.List;

import effigo.ayushi.newlearningportal.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
	private Long id;
	private String title;
	private String description;
	private long price;
	private List<CourseEntity.Category> category;
	
	public CourseDto(CourseEntity courseEntity) {
		this.id = courseEntity.getId();
		this.title = courseEntity.getTitle();
		this.description = courseEntity.getDescription();
		this.category = courseEntity.getCategory();
		this.price = courseEntity.getPrice();
	}
}
