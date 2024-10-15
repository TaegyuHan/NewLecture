
package co.kr.rlandboot3project.admin.repository;

import co.kr.rlandboot3project.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminMenuRepository extends JpaRepository<Menu, Long> {
}