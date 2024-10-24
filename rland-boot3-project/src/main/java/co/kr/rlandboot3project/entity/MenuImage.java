package co.kr.rlandboot3project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menu_image")
public class MenuImage {
    @Id
    @Size(max = 255)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "is_default")
    private Boolean isDefault;

//    @Column(name = "menu_id")
//    private Long menuId;

    @Size(max = 255)
    @Column(name = "src")
    private String src;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    @JsonBackReference // 다시 뒤로 참조하지 않도록 한다.
    private Menu menu;
}