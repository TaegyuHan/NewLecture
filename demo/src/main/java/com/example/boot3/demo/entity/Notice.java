package com.example.boot3.demo.entity;

public class Notice {
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Notice(int id) {
        this(id, "title", "content");
    }

    public Notice(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
