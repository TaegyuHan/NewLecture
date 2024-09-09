package com.example.boot3.demo.controller.admin;

import com.example.boot3.demo.entity.Menu;
import com.example.boot3.demo.service.menu.MenuService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller("adminMenuController")
@RequestMapping("admin/menu")
@MultipartConfig( // << 여기 진행해야함 파일 크기 설정
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 10 * 2 // 20MB
)
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping("list")
    public String list(
            Model model
    ) {
        model.addAttribute("menus", service.getList());
        return "admin/menu/list";
    }

    @GetMapping("reg")
    public String reg() {
        return "admin/menu/reg";
    }

    @PostMapping("reg")
    public String reg(
            MultipartFile img,
            HttpServletRequest request,
            Menu menu,
            @RequestParam("category-id") Long categoryId,
            @RequestParam("kor-name") String korName,
            @RequestParam("eng-name") String engName
    ) {
        menu.setCategoryId(categoryId);
        menu.setKorName(korName);
        menu.setEngName(engName);
        menu.setRegMemberId(1L);

        service.reg(menu);

        System.out.println(menu);

        if (img.isEmpty()) { // form 인코딩 방식을 잘 확인해야 한다.
            // 설정이 필요하다.
            return "redirect:reg";
        }

        String path = request.getServletContext().getRealPath("/image/product");
        System.out.println(path);

        File pathFile = new File(path);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }

        String fileName = img.getOriginalFilename();

        // 폴더 유효성 검사

        String fullPath = Paths.get(path, fileName).toString();

        try {
            img.transferTo(new File(fullPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:list";
    }
}