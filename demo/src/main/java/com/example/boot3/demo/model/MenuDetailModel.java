package com.example.boot3.demo.model;

import com.example.boot3.demo.entity.Menu;
import com.example.boot3.demo.entity.MenuImage;
import com.example.boot3.demo.entity.RcmdMenuView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDetailModel {
    private Menu menu;
    private List<MenuImage> images;
    private List<RcmdMenuView> rcmdMenuViews;
}
