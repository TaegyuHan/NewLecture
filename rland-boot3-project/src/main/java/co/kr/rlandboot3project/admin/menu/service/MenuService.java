package co.kr.rlandboot3project.admin.menu.service;

import co.kr.rlandboot3project.admin.menu.dto.MenuListDto;
import co.kr.rlandboot3project.admin.menu.dto.MenuResponseDto;
import co.kr.rlandboot3project.admin.menu.dto.MenuSearchDto;

import java.util.List;

public interface MenuService {
    MenuListDto create(MenuListDto menuListDto);
    MenuListDto update(MenuListDto menuListDto, Long menuId);
    void delete(Long id);

    MenuResponseDto getList(MenuSearchDto menuSearchDto);
    MenuListDto getById(Long id);
}