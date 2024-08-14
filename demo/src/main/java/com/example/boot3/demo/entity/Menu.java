package com.example.boot3.demo.entity;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private String img;
    private Date regDate;
    private Long categoryId;
    private Long regMemberId;
}
