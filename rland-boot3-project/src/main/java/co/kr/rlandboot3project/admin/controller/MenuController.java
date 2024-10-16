package co.kr.rlandboot3project.admin.controller;

import co.kr.rlandboot3project.admin.dto.MenuResponseDto;
import co.kr.rlandboot3project.admin.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("adminMenuController")
@RequestMapping("admin/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<MenuResponseDto> getList(
            @RequestParam(value = "p", defaultValue = "1") int page,
            @RequestParam(value = "q", required = false) String koName,
            @RequestParam(value = "cid", required = false) List<Long> categoryIds
    ) {
        MenuResponseDto response = menuService.getList(page, koName, categoryIds);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}