package co.kr.rlandboot3project.admin.menu.repository;

import co.kr.rlandboot3project.entity.Menu;
import org.springframework.data.domain.Page;

public interface MenuCustomRepository {
    Page<Menu> findAll(String korName, Integer price, Integer page, Integer size);
}
