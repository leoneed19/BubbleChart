package ru.mephi.bublechart.web.dto;

import lombok.Data;

@Data
public class AuthResponseDto {

    private String userName;
    private String realName;
    private String token;
    private String role;
}
