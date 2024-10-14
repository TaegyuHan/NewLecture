package co.kr.rlandboot3project.repository;

import co.kr.rlandboot3project.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByKorNameContaining(String korName, Pageable pageable);
    List<Menu> findByKorNameLike(String korName, Pageable pageable);

    // 사용자가 입력한 값이 korName과 같은 Menu 목록만 출력 (단 1페이지, regDate 내림차순)
    Page<Menu> findByKorName(String korName, Pageable pageable);

    // 메뉴 검색 목록 (이미 있기는 한데??? findAll()?)
    // 1. 규칙 : findBy-정렬+필터링
    // 2. 메소드 이름 : findBy-정렬+필터링
    List<Menu> findByOrderByRegDate();

    // 이것만 커스텀 하면 된다.
    // 메뉴 상세 (이미 있음 findById() )
    // 메뉴 등록 (이미 있음 save() )
    // 메뉴 수정 (이미 있음 save() )
    // 메뉴 삭제 (이미 있음 delete() )
}
