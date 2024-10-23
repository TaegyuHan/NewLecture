package co.kr.rlandboot3project.admin.menu.service;

import co.kr.rlandboot3project.admin.menu.dto.MenuListDto;
import co.kr.rlandboot3project.admin.menu.dto.MenuResponseDto;

import java.util.List;

public interface MenuService {
    MenuListDto create(MenuListDto menuListDto);
    MenuListDto update(MenuListDto menuListDto, Long menuId);
    void delete(Long id);

    MenuResponseDto getList(Integer page, String koName, List<Long> categoryIds);
    MenuListDto getById(Long id);
}