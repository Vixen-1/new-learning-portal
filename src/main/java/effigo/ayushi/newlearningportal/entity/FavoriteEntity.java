package effigo.ayushi.newlearningportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "favorites")
public class FavoriteEntity {

	@Id
	@Column(name = "favorite_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	
}
