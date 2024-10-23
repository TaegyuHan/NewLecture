package co.kr.rlandboot3project.admin.menu.mapper;

import co.kr.rlandboot3project.admin.menu.dto.MenuListDto;
import co.kr.rlandboot3project.admin.menu.dto.MenuResponseDto;
import co.kr.rlandboot3project.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    public static MenuListDto mapToDto(Menu menu) {
        if (menu == null) {
            return null;
        }

        return MenuListDto.builder()
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

    public static Menu mapToEntity(MenuListDto menuListDto) {
        if (menuListDto == null) {
            return null;
        }

        return Menu.builder()
                .id(menuListDto.getId())
                .korName(menuListDto.getKorName())
                .engName(menuListDto.getEngName())
                .price(menuListDto.getPrice())
                .regDate(menuListDto.getRegDate())
                .categoryId(menuListDto.getCategoryId())
                .regMemberId(menuListDto.getRegMemberId())
                .images(menuListDto.getImages())
                .build();
    }
}