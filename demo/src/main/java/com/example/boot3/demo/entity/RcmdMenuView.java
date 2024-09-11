package com.example.boot3.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RcmdMenuView {
    private Long id;
    private Long menuId;
    private Long rMenuId;
    private Long memberId;
    // ---------------- 추가 목록 ----------------
    private String img;
    // ---------------- 추가 목록 ----------------
    private String korName;
    private String engName;
    private Long price;
}