package com.flexx.register.model;

import com.flexx.register.entity.UserEntity;
import com.flexx.register.model.enums.DocumentType;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NonNull
    private String fullName;

    @NonNull
    private String documentNumber;

    @NonNull
    private DocumentType documentType;

    @Nullable
    private String password;

    public static UserEntity getEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .document(userDTO.getDocumentNumber())
                .fullName(userDTO.getFullName())
                .documentType(userDTO.getDocumentType().getValue())
                .password(userDTO.getPassword()).build();
    }


}
