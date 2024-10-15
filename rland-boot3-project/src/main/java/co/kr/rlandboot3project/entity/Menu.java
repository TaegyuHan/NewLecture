package co.kr.rlandboot3project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "kor_name")
    private String korName;

    @Size(max = 255)
    @Column(name = "eng_name")
    private String engName;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "reg_date", nullable = false)
    private Instant regDate;

    private Long categoryId;
    private Long regMemberId;

    @OneToMany(mappedBy = "menu")
    private List<MenuImage> images;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "reg_member_id")
//    private Member regMember;
}