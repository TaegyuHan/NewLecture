package co.kr.rlandboot3project.repository;

import co.kr.rlandboot3project.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;


@DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    @Test
    void joinTest() {
        List<Menu> menus = menuRepository.findAllWithDefaultImage("아메리카노", List.of(1L, 2L), PageRequest.of(0, 10));
    }

    @Test
    void queryTest() {
        Sort sort = Sort.by(Sort.Order.asc("korName"));
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Menu> menus = menuRepository.findByKorName("아메리카노", pageable);
//        for (Menu menu : menus.getContent()) {
//            System.out.println(menu);
//        }

        // 이 연산이 %아메리카노%와 같은 연산이다.
//        List<Menu> menus1 = menuRepository.findByKorNameContaining("아메리카노", pageable);
//        for (Menu menu : menus1) {
//            System.out.println(menu);
//        }

        // 이 연산이 아메리카노와 같은 연산이다.
//        List<Menu> menus2 = menuRepository.findByKorNameLike("아메리카노", pageable);
//        for (Menu menu : menus2) {
//            System.out.println(menu);
//        }

//        List<Long> categoryIds = List.of(1L, 2L);
//        Page<Menu> menus3 = menuRepository
//                .findAllByKorNameContainingAndPriceGreaterThanEqualAndCategoryIdIn(
//                        "아",
//                        5_000,
//                        categoryIds,
//                        pageable
//                );
//        for (Menu menu : menus3.getContent()) {
//            System.out.println(menu);
//        }

//        List<Long> categoryIds = List.of(1L, 2L, 3L);
//        Instant startTime = Instant.now()
//                .minus(1, ChronoUnit.MONTHS)
//                .atZone(ZoneId.systemDefault())
//                .toInstant();
//
//        Instant endTime = Instant.now();
//        Page<Menu> menus4 = menuRepository.findByRegDateBetween(
//                startTime,
//                endTime,
//                pageable
//        );

//        for (Menu menu : menus4.getContent()) {
//            System.out.println(menu);
//        }


        List<Menu> menus5 = menuRepository.findMenuByKorNameAndPriceAndCategoryId(
                "아메리카노",
                5_000,
                List.of(1L, 2L),
                pageable
        );

    }

    @Test
    void streamTest() {
        List <Menu> menus = menuRepository.findAll().stream()
                .filter(menu -> 5_000 <= menu.getPrice())
                .toList();

        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    @Test
    void findByOrderByRegDate() {
        List<Menu> menus = menuRepository.findByOrderByRegDate();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    @Test
    void findAll() {
        Sort sort = Sort.by(List.of(
                Sort.Order.asc("regDate"),
                Sort.Order.desc("korName")
        ));
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Menu> page = menuRepository.findAll(pageable);

        // 6개씩 나눴을 떄의 페이지 수
        int count = page.getContent().size();
        System.out.println("count = " + count);

        // 전체 레코드 수
        long totalElements = page.getTotalElements();
        System.out.println("totalElements = " + totalElements);

        // 다음페이지는 있는지
        boolean hasNext = page.hasNext();
        System.out.println("hasNext = " + hasNext);

        // 이전페이지는 있는지
        boolean hasPrevious = page.hasPrevious();
        System.out.println("hasPrevious = " + hasPrevious);

        // 현재 페이지는 몇 개의 레코드를 가지고 있는거지?
        int numberOfElements = page.getNumberOfElements();
        System.out.println("numberOfElements = " + numberOfElements);

        // 현재 페이지는 몇 번째 페이지인가?
        int number = page.getNumber();
        System.out.println("number = " + number);
    }
}