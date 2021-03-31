package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserListDto {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserDataDto> data;
    private SupportDto support;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDataDto {
        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SupportDto {
        private String url;
        private String text;
    }
}


