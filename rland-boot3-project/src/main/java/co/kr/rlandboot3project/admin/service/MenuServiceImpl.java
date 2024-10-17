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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public MenuDto getById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. id=" + id));

        return MenuMapper.mapToDto(menu);
    }

    // POST: api/v1/admin/menus
    @Override
    public MenuDto create(MenuDto menuDto) {
        Menu menu = MenuMapper.mapToEntity(menuDto);
        Menu savedMenu = menuRepository.save(menu);

        return menuRepository.findById(savedMenu.getId())
                .map(MenuMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. id=" + savedMenu.getId()));
    }

    // PUT: api/v1/admin/menus/{menusId}
    // isolation level
    // 1. READ_UNCOMMITTED - dirty read
    // 2. READ_COMMITTED - non-repeatable read
    // 3. REPEATABLE_READ - phantom read < 기본 설정
    // 4. SERIALIZABLE - all
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public MenuDto update(MenuDto menuDto, Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. id=" + menuId));

        if (menuDto.getKorName() != null) {
            menu.setKorName(menuDto.getKorName());
        }
        if (menuDto.getEngName() != null) {
            menu.setEngName(menuDto.getEngName());
        }

        if (menuDto.getPrice() != null) {
            menu.setPrice(menuDto.getPrice());
        }

        Menu savedMenu = menuRepository.save(menu);
        return MenuMapper.mapToDto(savedMenu);
    }

    @Override
    public void delete(Long id) {

    }
}