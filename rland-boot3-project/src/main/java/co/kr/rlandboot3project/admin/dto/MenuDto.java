package co.kr.rlandboot3project.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private Long id;
    private String korName;
    private String engName;
    private Integer price;
    private Instant regDate;

    private Long categoryId;
    private Long regMemberId;
}