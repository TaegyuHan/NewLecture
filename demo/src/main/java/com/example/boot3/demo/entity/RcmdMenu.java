package com.example.boot3.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RcmdMenu {
    private Long id;
    private Long menuId;
    private Long rMenuId;
    private Long memberId;
}