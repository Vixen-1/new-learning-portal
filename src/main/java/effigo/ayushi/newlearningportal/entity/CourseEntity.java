package effigo.ayushi.newlearningportal.entity;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Courses")
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
	
	public enum Category{
		JAVA, SPA, CPP, PYTHON, ML, AI, OOPS, SPRING, DSA, REACT, NODE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long id;
	
	@Column(name = "course_title")
	private String title;
	
	@Column(name = "course_description")
	private String description;
	
	@Column(name = "course_category")
	private List<Category> category;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "course_price")
	private Long price;
	
}
