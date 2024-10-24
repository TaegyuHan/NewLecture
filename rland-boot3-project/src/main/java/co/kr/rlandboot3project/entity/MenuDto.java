package co.kr.rlandboot3project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "menu_dto")
public class MenuDto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Size(max = 255)
    @Column(name = "default_image")
    private String defaultImage;

    @Size(max = 255)
    @Column(name = "eng_name")
    private String engName;

    @Size(max = 255)
    @Column(name = "kor_name")
    private String korName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "reg_date")
    private Instant regDate;

    @Column(name = "reg_member_id")
    private Long regMemberId;

}