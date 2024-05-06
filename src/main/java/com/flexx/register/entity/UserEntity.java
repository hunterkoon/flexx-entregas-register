package com.flexx.register.entity;


import com.flexx.register.model.enums.DocumentType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "flexx", name = "tb_user_register")
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private String document;

    @Column
    private String fullName;

    @Column
    private String documentType;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phoneNumber;

}
