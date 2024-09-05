package com.example.boot3.demo.controller.admin;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller("adminMenuController")
@RequestMapping("admin/menu")
@MultipartConfig( // << 여기 진행해야함 파일 크기 설정
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 10 * 2 // 20MB
)
public class MenuController {

    @GetMapping("list")
    public String list() {
        return "admin/menu/list";
    }

    @GetMapping("reg")
    public String reg() {
        return "admin/menu/reg";
    }

    @PostMapping("reg")
    public String reg(
            MultipartFile img
//            Menu menu
    ) throws IOException {

        if (img.isEmpty()) {
            return "redirect:reg";
        }

        img.transferTo(new File("C:/upload/" + img.getOriginalFilename()));
        // 파일 저장 방법 2가지
        // 사용자 이미지는 컨택스트를 이용해서 저장하는 것이 좋다.
        // 사용자 리소스를 따로 관리하는 방법이 필요하다.
        // 리소스를 1개로 지정해서 많은 서버가 동시에 사용하는 방법으로 가야한다.

        System.out.println(img.getOriginalFilename());
        return "redirect:list";
    }
}