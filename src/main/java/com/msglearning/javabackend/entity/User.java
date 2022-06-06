package com.msglearning.javabackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = User.TABLE_NAME)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true,
            nullable = false)
    private String email;

    @Column(unique = true,
            nullable = false)
    private String phone;

    @Column
    private String profileImage;

    @Column(columnDefinition = "integer default 0")
    private Integer role;

    @OneToMany(mappedBy = "owner")
    private List<Stuff> stuffList;

}
