package com.notBank.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class AccountDto {
    private String type;
    private Long userId;
    private String userType;
    private Integer amount;
}
