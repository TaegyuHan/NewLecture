package co.kr.rlandboot3project.dto;

import co.kr.rlandboot3project.entity.Menu;
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

    public static MenuDto of(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .korName(menu.getKorName())
                .engName(menu.getEngName())
                .price(menu.getPrice())
                .categoryId(menu.getCategoryId())
                .regMemberId(menu.getRegMemberId())
                .regDate(menu.getRegDate())
                .build();
    }

    public Menu toMenu() {
        return Menu.builder()
                .korName(korName)
                .engName(engName)
                .price(price)
                .categoryId(categoryId)
                .regDate(LocalDateTime.now())
                .build();
    }
}