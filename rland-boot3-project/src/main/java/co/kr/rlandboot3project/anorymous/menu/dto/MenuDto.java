package co.kr.rlandboot3project.anorymous.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {

    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Long categoryId;
    private Long regMemberId;
    private LocalDateTime regDate;

    private String defaultImage;


}