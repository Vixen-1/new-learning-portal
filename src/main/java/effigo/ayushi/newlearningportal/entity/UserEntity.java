package effigo.ayushi.newlearningportal.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
	public enum Role{
		ADMIN, AUTHOR, LEARNER
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private long id;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_role")
	private Role role;
	

	//adding one to many relation
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<RegisterEntity> registeredCourses = new HashSet<>();

	public void addRegisteredCourse(RegisterEntity registeredCourse) {
		registeredCourses.add(registeredCourse);
		registeredCourse.setUser(this);
	}

}
