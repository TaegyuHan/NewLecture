package co.kr.rlandboot3project.admin.menu.service;

import co.kr.rlandboot3project.admin.menu.dto.MenuListDto;
import co.kr.rlandboot3project.admin.menu.dto.MenuResponseDto;
import co.kr.rlandboot3project.admin.menu.mapper.MenuMapper;
import co.kr.rlandboot3project.entity.Menu;
import co.kr.rlandboot3project.anorymous.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.LongStream;

@Service("adminMenuService")
@RequiredArgsConstructor
public class DefaultMenuService implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public MenuResponseDto getList(Integer page, String korName, List<Long> categoryIds) {
        Sort sort = Sort.by("regDate").descending();
        // Pageable pageable = PageRequest.of(page - 1,6, sort);
        Page<Menu> menuPage = menuRepository.findAll(korName, 1000, 1, 6);

        List<MenuListDto> menuListDtos = menuPage.getContent()
                .stream()
                .map(MenuMapper::mapToDto)
                .toList();

        long totalCount = menuPage.getTotalElements();
        long totalPage = menuPage.getTotalPages();
        System.out.println("totalPage = " + totalPage);
        boolean hasNextPage = menuPage.hasNext();
        boolean hasPrevPage = menuPage.hasPrevious();

        int offset = (page - 1) % 5;
        int startNum = page - offset;

        List<Long> pages = LongStream
                .range(startNum, startNum + 5)
                .boxed().toList();

        return MenuResponseDto.builder()
                .menus(menuListDtos)
                .totalCount(totalCount)
                .totalPage(totalPage)
                .hasNextPage(hasNextPage)
                .hasPrevPage(hasPrevPage)
                .pages(pages)
                .build();
    }

    @Override
    public MenuListDto getById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. id=" + id));

        return MenuMapper.mapToDto(menu);
    }

    // POST: api/v1/admin/menus
    @Override
    public MenuListDto create(MenuListDto menuListDto) {
        Menu menu = MenuMapper.mapToEntity(menuListDto);
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
    public MenuListDto update(MenuListDto menuListDto, Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. id=" + menuId));

        if (menuListDto.getKorName() != null) {
            menu.setKorName(menuListDto.getKorName());
        }
        if (menuListDto.getEngName() != null) {
            menu.setEngName(menuListDto.getEngName());
        }

        if (menuListDto.getPrice() != null) {
            menu.setPrice(menuListDto.getPrice());
        }

        Menu savedMenu = menuRepository.save(menu);
        return MenuMapper.mapToDto(savedMenu);
    }

    @Override
    public void delete(Long id) {

    }
}