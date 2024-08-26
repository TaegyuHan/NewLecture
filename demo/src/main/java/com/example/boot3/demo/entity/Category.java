package com.example.boot3.demo.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Category {
    private Long id;
    private String name;
}
