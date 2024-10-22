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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service("adminMenuService")
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public MenuResponseDto getList(Integer page, String korName, List<Long> categoryIds){
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page - 1,5, sort);
        Page<Menu> menuPage = menuRepository.findAll(korName, categoryIds, pageable);

        List<MenuDto> menuDtos = menuPage
                .getContent()
                .stream()
                .map(MenuMapper::mapToDto)
                .toList();

        long totalCount = menuPage.getTotalElements();
        long totalPage = menuPage.getTotalPages();
        boolean hasNextPage = menuPage.hasNext();
        boolean hasPrevPage = menuPage.hasPrevious();

        int offset = (page - 1) % 5;
        int startNum = page - offset;

        List<Long> pages = LongStream
                .range(startNum, startNum + 4)
                .boxed().toList();

        return MenuResponseDto.builder()
                .menus(menuDtos)
                .totalCount(totalCount)
                .totalPage(totalPage)
                .hasNextPage(hasNextPage)
                .hasPrevPage(hasPrevPage)
                .pages(pages)
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