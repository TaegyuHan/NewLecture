package com.example.boot3.demo.entity;


import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private Date regDate;
    private Date updateDate;
    private Long hitCount;
    private Long regMemberId;
}