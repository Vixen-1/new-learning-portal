package effigo.ayushi.newlearningportal.dto;


import effigo.ayushi.newlearningportal.entity.RegisterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteDto {
	 private Long id;
	 private RegisterEntity registerEntity;

	  

}
