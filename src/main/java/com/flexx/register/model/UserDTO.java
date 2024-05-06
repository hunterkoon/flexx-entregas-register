package com.flexx.register.model;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.flexx.register.entity.UserEntity;
import com.flexx.register.model.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
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

    public static List<UserDTO> getListOfUserByEntity(Iterable<UserEntity> userEntityList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        userEntityList.forEach(user -> userDTOList.add(getUserByEntity(user)));
        return userDTOList;
    }

    private static UserDTO getUserByEntity(UserEntity userEntity) {
        return UserDTO.builder()
                .documentNumber(userEntity.getDocument())
                .fullName(userEntity.getFullName())
                .documentType(DocumentType.valueOf(userEntity.getDocumentType()))
                .build();
    }

}
