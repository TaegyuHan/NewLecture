package co.kr.rlandboot3project.service;

import co.kr.rlandboot3project.dto.MenuImageDto;
import co.kr.rlandboot3project.entity.Menu;
import co.kr.rlandboot3project.entity.MenuImage;
import co.kr.rlandboot3project.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public List<Menu> getList() {
        return menuRepository.findAll();
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Long menuId, Menu menu) {

        Menu findMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. id=" + menuId));

        return menuRepository.save(findMenu);
    }

    @Override
    public void delete(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    @Override
    public Menu getMenu(Long menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다. id=" + menuId));
    }

    @Override
    public MenuImageDto updateImage(Long menuId, Long imagesId, MenuImage image, MultipartFile file) {
        return null;
    }
}