package co.kr.rlandboot3project.admin.service;

import co.kr.rlandboot3project.admin.dto.MenuDto;
import co.kr.rlandboot3project.admin.dto.MenuResponseDto;
import co.kr.rlandboot3project.admin.mapper.MenuMapper;
import co.kr.rlandboot3project.entity.Menu;
import co.kr.rlandboot3project.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminMenuService")
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public MenuResponseDto getList(int page, String korName, List<Long> categoryIds) {

        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page - 1, 6, sort);
        Page<Menu> menuPage = menuRepository.findAll(korName, categoryIds, pageable);

        List<MenuDto> menuDtoList = menuPage
                .map(MenuMapper::mapToDto)

                .getContent();

        long totalCount = menuPage.getTotalElements();

        return MenuResponseDto
                .builder()
                .menus(menuDtoList)
                .totalCount(totalCount)
                .build();
    }
}