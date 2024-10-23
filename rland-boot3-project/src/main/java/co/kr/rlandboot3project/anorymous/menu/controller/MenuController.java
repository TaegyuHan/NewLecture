package co.kr.rlandboot3project.anorymous.menu.controller;

import co.kr.rlandboot3project.entity.Menu;
import co.kr.rlandboot3project.anorymous.menu.dto.MenuDto;
import co.kr.rlandboot3project.anorymous.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    private final ListCrudRepository<Menu, Long> menuRepository;

    @GetMapping
    public List<Menu> getList(
            @RequestParam(name = "p", defaultValue = "1") int page,
            @RequestParam(name = "s", defaultValue = "1") int size
    ) {
        return menuRepository.findAll();
    }

    // GET api/v1/menus/1
    @GetMapping("{menuId}")
    public ResponseEntity<MenuDto> get(
            @PathVariable("menuId") Long menuId) {
        MenuDto menuDto = MenuDto.builder().korName("맛난 커피").build();
        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MenuDto> create(
            @RequestBody MenuDto menuDto) {
        System.out.println(menuDto);
        MenuDto newOne = MenuDto.builder().korName("방금 만들어진 커피").build();
        return new ResponseEntity<>(menuDto, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<MenuDto> update(MenuDto menuDto) {
        menuDto.setKorName("방금 수정된 커피");
        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    }

    @PutMapping("{id}/image")
    public ResponseEntity<MenuDto> updateImage(MenuDto menuDto) {
        menuDto.setDefaultImage("방금 수정된 이미지");
        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    }

    // 3번 회원이 등록 한 메뉴가 있다.
    // 2번 메뉴가 그것인데
    // 그 메뉴의 이미지를 등록하는 URL은?
    // POST /api/v1/menus/2/images

//    @PutMapping("{id}/price/{price}")
//    public ResponseEntity<MenuDto> updatePriceWithValue(MenuDto menuDto) {
//        menuDto.setKorName("방금 수정된 커피");
//        return new ResponseEntity<>(menuDto, HttpStatus.OK);
//    }
//
//    @PutMapping("{id}/price")
//    public ResponseEntity<MenuDto> updatePrice(MenuDto menuDto) {
//        menuDto.setKorName("방금 수정된 커피");
//        return new ResponseEntity<>(menuDto, HttpStatus.OK);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(
            @PathVariable("id") Long id) {
        System.out.println(String.format(" %d번 항목이 삭제되었습니다.", id));
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}