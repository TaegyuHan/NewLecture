package co.kr.rlandboot3project.admin.service;

import co.kr.rlandboot3project.admin.dto.MenuDto;
import co.kr.rlandboot3project.admin.dto.MenuResponseDto;

import java.util.List;

public interface MenuService {
    MenuDto create(MenuDto menuDto);
    MenuDto update(MenuDto menuDto, Long menuId);
    void delete(Long id);

    MenuResponseDto getList(Integer page, String koName, List<Long> categoryIds);
    MenuDto getById(Long id);
}