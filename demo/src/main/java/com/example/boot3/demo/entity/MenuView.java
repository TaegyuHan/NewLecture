package com.example.boot3.demo.entity;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MenuView {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Date regDate;
    private Long regMemberId;
    private Long categoryId;
    private String categoryName;
    private String img;

    // TODO: 이미지 처리 해야함 2024-08-28
    // private List<MenuImage> imgs;
}