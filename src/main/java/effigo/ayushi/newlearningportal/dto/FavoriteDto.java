package effigo.ayushi.newlearningportal.dto;

import effigo.ayushi.newlearningportal.entity.FavoriteEntity;
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

	    public FavoriteDto(FavoriteEntity favoriteEntity) {
	        this.id = favoriteEntity.getId();
	        this.registerEntity = favoriteEntity.getRegisterEntity();
	    }

}
