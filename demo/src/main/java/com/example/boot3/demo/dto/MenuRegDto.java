package com.example.boot3.demo.dto;


import com.example.boot3.demo.entity.Menu;
import com.example.boot3.demo.entity.MenuImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuRegDto {
    private Menu menu;
    private List<MenuImage> images;
}
