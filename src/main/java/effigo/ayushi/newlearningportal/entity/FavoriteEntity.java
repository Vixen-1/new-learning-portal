package effigo.ayushi.newlearningportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "favorites")
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteEntity {

	@Id
	@Column(name = "favorite_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "registered_id")
	private RegisterEntity registerEntity;	
}
