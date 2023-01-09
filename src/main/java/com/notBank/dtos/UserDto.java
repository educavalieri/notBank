package com.notBank.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UserDto {
    private String name;
    private String email;
    private String password;




}
