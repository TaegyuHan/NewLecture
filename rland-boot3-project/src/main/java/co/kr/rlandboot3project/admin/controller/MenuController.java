package co.kr.rlandboot3project.admin.controller;

import co.kr.rlandboot3project.admin.dto.MenuDto;
import co.kr.rlandboot3project.admin.dto.MenuResponseDto;
import co.kr.rlandboot3project.admin.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminMenuController")
@RequestMapping("admin/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    // 생성
    // POST /api/v1/menus
    @PostMapping
    public ResponseEntity<MenuDto> create(
            @RequestBody MenuDto menuDto
    ) {
        System.out.println(menuDto);
        MenuDto response = menuService.create(menuDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 수정: id: 1693
    // PUT /api/v1/menus/{menuId}
    @PutMapping("{menuId}")
    public ResponseEntity<MenuDto> update(
            @RequestBody MenuDto menuDto,
            @PathVariable("menuId") Long menuId
    ) {
        MenuDto response = menuService.update(menuDto, menuId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 삭제
    // DELETE /api/v1/menus/{menuId}
    @DeleteMapping("{menuId}")
    public ResponseEntity<Void> delete(
            @PathVariable("menuId") Long menuId
    ) {
        menuService.delete(menuId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 조회
    // GET /api/v1/menus/{menuId}
    @GetMapping("{menuId}")
    public ResponseEntity<MenuDto> get(
            @PathVariable(value = "menuId") Long menuId
    ) {
        MenuDto response = menuService.getById(menuId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // GET /api/v1/menus
    @GetMapping
    public ResponseEntity<MenuResponseDto> getList(
            @RequestParam(value = "p", defaultValue = "1") int page,
            @RequestParam(value = "k", required = false) String koName,
            @RequestParam(value = "cid", required = false) List<Long> categoryIds
    ) {
        MenuResponseDto response = menuService.getList(page, koName, categoryIds);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}