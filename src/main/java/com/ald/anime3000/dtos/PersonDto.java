package com.ald.anime3000.dtos;

import com.ald.anime3000.enums.StatusUser;
import com.ald.anime3000.models.person.PersonModel;
import com.ald.anime3000.models.user.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class PersonDto {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private Date birthdate;
    @NotBlank
    private String country;
}
