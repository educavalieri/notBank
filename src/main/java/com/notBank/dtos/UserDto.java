package com.notBank.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UserDto {
    @NotNull(message = "name must be full field")
    @NotBlank
    private String name;

    @NotBlank
    @NotNull(message = "name must be full field")
    private String email;

    @NotBlank
    @NotNull(message = "password must be full field")
    private String password;




}
