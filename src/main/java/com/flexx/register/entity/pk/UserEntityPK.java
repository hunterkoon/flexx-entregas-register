package com.flexx.register.entity.pk;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityPK implements Serializable  {

    @Serial
    private static final long serialVersionUID = 1L;

    private String documentNumber;

}
