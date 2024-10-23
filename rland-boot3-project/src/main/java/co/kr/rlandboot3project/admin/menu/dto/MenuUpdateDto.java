package co.kr.rlandboot3project.admin.menu.dto;

import co.kr.rlandboot3project.entity.MenuImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuUpdateDto {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Instant regDate;

    private Long categoryId;
    private Long regMemberId;

    //1. 이미지들
    private List<MenuImage> images;

    //    //2. 대표이미지
    //    private MenuImage image;
    //
    //    //3. 이미지 src
    //    private String imageSrc;

}