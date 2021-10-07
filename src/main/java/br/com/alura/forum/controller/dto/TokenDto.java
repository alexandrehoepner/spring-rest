package br.com.alura.forum.controller.dto;

import lombok.Data;

@Data
public class TokenDto {

    private String token;
    private String bearer;

    public TokenDto(String token, String bearer) {
        this.token = token;
        this.bearer = bearer;
    }
}
