package co.kr.rlandboot3project.admin.menu.controller;

import co.kr.rlandboot3project.admin.menu.dto.MenuListDto;
import co.kr.rlandboot3project.admin.menu.dto.MenuResponseDto;
import co.kr.rlandboot3project.admin.menu.service.MenuService;
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
    public ResponseEntity<MenuListDto> create(
            @RequestBody MenuListDto menuListDto
    ) {
        System.out.println(menuListDto);
        MenuListDto response = menuService.create(menuListDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 수정: id: 1693
    // PUT /api/v1/menus/{menuId}
    @PutMapping("{menuId}")
    public ResponseEntity<MenuListDto> update(
            @RequestBody MenuListDto menuListDto,
            @PathVariable("menuId") Long menuId
    ) {
        MenuListDto response = menuService.update(menuListDto, menuId);
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
    public ResponseEntity<MenuListDto> get(
            @PathVariable(value = "menuId") Long menuId
    ) {
        MenuListDto response = menuService.getById(menuId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // GET /api/v1/menus
    @GetMapping
    public ResponseEntity<MenuResponseDto> getList(
            @RequestParam(value = "p", defaultValue = "1") Integer page,
            @RequestParam(value = "k", required = false) String koName,
            @RequestParam(value = "cid", required = false) List<Long> categoryIds
    ) {
        MenuResponseDto response = menuService.getList(page, koName, categoryIds);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}