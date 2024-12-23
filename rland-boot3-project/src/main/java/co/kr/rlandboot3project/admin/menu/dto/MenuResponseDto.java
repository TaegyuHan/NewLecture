package co.kr.rlandboot3project.admin.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuResponseDto {
    private long totalCount;
    private long totalPage;
    private boolean hasNextPage;
    private boolean hasPrevPage;
    private List<MenuListDto> menus;
    private List<Long> pages;
}