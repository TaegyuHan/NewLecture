package co.kr.rlandboot3project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Menu {

    @Id
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Long categoryId;
    private Long regMemberId;
    private LocalDateTime regDate;
}
