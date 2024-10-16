package co.kr.rlandboot3project.admin.service;

import co.kr.rlandboot3project.admin.dto.MenuResponseDto;

import java.util.List;

public interface MenuService {
    MenuResponseDto getList(int page, String koName, List<Long> categoryIds);
}
