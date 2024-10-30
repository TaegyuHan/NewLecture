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
public class MenuSearchDto {
    private Integer page;
    private Integer size;
    private String keyWord;
    private List<Integer> categoryId;

    public boolean isValidate() {
        boolean result = true;

        if (page == null || page < 0) {
            page = 1;
        }

        if (size == null) {
            size = 10;
        }

        return result;
    }
}