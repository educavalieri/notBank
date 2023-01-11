package com.notBank.entities;

import javax.persistence.*;
import lombok.*;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    private String userType;
    private Integer amount;

    @OneToMany(mappedBy = "account")
    private List<User> users = new ArrayList<>();

}
