package co.kr.rlandboot3project.admin.mapper;

import co.kr.rlandboot3project.admin.dto.MenuDto;
import co.kr.rlandboot3project.admin.dto.MenuResponseDto;
import co.kr.rlandboot3project.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    public static MenuDto mapToDto(Menu menu) {
        if (menu == null) {
            return null;
        }

        return MenuDto.builder()
                .id(menu.getId())
                .korName(menu.getKorName())
                .engName(menu.getEngName())
                .price(menu.getPrice())
                .regDate(menu.getRegDate())
                .categoryId(menu.getCategoryId())
                .regMemberId(menu.getRegMemberId())
                .images(menu.getImages())
                .build();
    }

    public static MenuResponseDto mapToResponseDto(Page<Menu> menus) {
        if (menus == null) {
            return null;
        }

        return MenuResponseDto.builder()
                .totalCount((int) menus.getTotalElements())
                .menus(menus.map(MenuMapper::mapToDto).getContent())
                .build();
    }

    public static Menu mapToEntity(MenuDto menuDto) {
        if (menuDto == null) {
            return null;
        }

        return Menu.builder()
                .id(menuDto.getId())
                .korName(menuDto.getKorName())
                .engName(menuDto.getEngName())
                .price(menuDto.getPrice())
                .regDate(menuDto.getRegDate())
                .categoryId(menuDto.getCategoryId())
                .regMemberId(menuDto.getRegMemberId())
                .images(menuDto.getImages())
                .build();
    }
}