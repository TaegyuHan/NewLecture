package co.kr.rlandboot3project.anorymous.menu.dto;

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


}
