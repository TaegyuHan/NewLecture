package co.kr.rlandboot3project.service;

import co.kr.rlandboot3project.dto.MenuImageDto;
import co.kr.rlandboot3project.entity.Menu;
import co.kr.rlandboot3project.entity.MenuImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MenuService {
    List<Menu> getList();

    Menu save(Menu menu);

    Menu update(Long menuId, Menu menu);

    void delete(Long menuId);

    Menu getMenu(Long menuId);

    MenuImageDto updateImage(Long menuId, Long imagesId, MenuImage image, MultipartFile file);
}
