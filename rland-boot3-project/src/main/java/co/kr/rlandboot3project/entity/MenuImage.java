package co.kr.rlandboot3project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MenuImage {
    @Id
    private String id;
    private String src;
    private Long menu_id;
    private Boolean is_default;
}
