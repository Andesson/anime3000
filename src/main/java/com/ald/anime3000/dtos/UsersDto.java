package com.ald.anime3000.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
