package co.kr.rlandboot3project.dto;

import co.kr.rlandboot3project.entity.MenuImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuImageDto {

    private String id;
    private String src;
    private Long menu_id;
    private Boolean is_default;

    public MenuImage toMenuImage() {
        return MenuImage.builder()
                .src(src)
                .menu_id(menu_id)
                .is_default(is_default)
                .build();

    }
}
