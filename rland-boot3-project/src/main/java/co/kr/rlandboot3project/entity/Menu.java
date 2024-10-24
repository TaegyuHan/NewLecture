package co.kr.rlandboot3project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "kor_name")
    private String korName;

    @Size(max = 255)
    @Column(name = "eng_name")
    private String engName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "reg_date", insertable = false) // insertable = false: insert 시에 제외
    private Instant regDate;

    private Long categoryId;
    private Long regMemberId;

    // fetch = FetchType.LAZY: 지연로딩
    // fetch = FetchType.EAGER: 즉시로딩
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference // 참조 가능하게 한다.
    private List<MenuImage> images;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "reg_member_id")
//    private Member regMember;
}