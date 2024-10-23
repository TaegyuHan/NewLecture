package co.kr.rlandboot3project.anorymous.menu.repository;

import co.kr.rlandboot3project.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

//    @Query("""
//        FROM Menu
//        WHERE (:korName is null or korName like concat('%', :korName, '%'))
//            AND (:categoryIds is null or categoryId in :categoryIds)
//    """)
//    List<Menu> findByQuery(
//            String korName,
//            List<Long> categoryIds,
//            Pageable pageable
//    );

    @Query("""
        FROM Menu
        WHERE (:korName IS NULL OR korName LIKE concat('%', :korName, '%'))
            AND (:categoryIds IS NULL OR categoryId IN :categoryIds)
    """)
    Page<Menu> findAll(String korName, List<Long> categoryIds, Pageable pageable);

    // 목록 < 요것만 커스텀하게 만든다.
    // 단일 객체
    // 삽입
    // 삭제
    // 수정

    // 사용자가 입력한 값이 korName과 같은 Menu 목록만 출력 (단 1페이지, regDate 내림차순)
    // Page<Menu> findByKorName(String korName, Pageable pageable);

    // 메뉴 검색 목록 (이미 있기는 한데??? findAll()?)
    // 1. 규칙 : findBy-정렬+필터링
    // 2. 메소드 이름 : findBy-정렬+필터링
    // List<Menu> findByOrderByRegDate();

    // findBy + 필드명 + 연산자
    // Page<Menu> findAllByKorNameContainingAndPriceGreaterThanEqualAndCategoryIdIn(String korName, Integer price, List<Long> categoryIds, Pageable pageable);

    // 등록된지 한 달 이내의 메뉴만 조회 등록날짜 순으로 역순 페이지는 1페이지
    // Page<Menu> findByRegDateBetween(Instant startTime, Instant endTime, Pageable pageable);

//    @Query("""
//        FROM Menu
//        WHERE korName like concat('%', :korName, '%')
//            AND (:price is null or :price <= price)
//            AND (:categoryIds is null or categoryId in :categoryIds)
//    """)
//    List<Menu> findMenuByKorNameAndPriceAndCategoryId(
//            String korName,
//            Integer price,
//            List<Long> categoryIds,
//            Pageable pageable
//    );

    // 둘의 차이점
    // LocalDateTime:
    // Instant:
    // 이것만 커스텀 하면 된다.
    // 메뉴 상세 (이미 있음 findById() )
    // 메뉴 등록 (이미 있음 save() )
    // 메뉴 수정 (이미 있음 save() )
    // 메뉴 삭제 (이미 있음 delete() )

    //    @Query("""
//        SELECT m
//        FROM Menu m
//        LEFT JOIN FETCH MenuImage mi
//            ON m.id = mi.menu.id
//        WHERE mi.isDefault = true
//    """)
//    List<Menu> findAllWithDefaultImage(String korName, List<Long> categoryIds, Pageable pageable);
//
//    List<Menu> findByKorNameContainingAndCategoryIdIn(String korName, List<Long> categoryIds, Pageable pageable);
//    List<Menu> findByKorNameContaining(String korName, Pageable pageable);
//    List<Menu> findByKorNameLike(String korName, Pageable pageable);

}