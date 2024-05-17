package com.flexx.register.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flexx.register.entity.UserEntity;
import com.flexx.register.model.enums.DocumentType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome Completo é obrigatório")
    @Size(min = 2, max = 100, message = "Nome completo deve conter entre 2 e 100 caracteres")
    private String fullName;

    @NotEmpty(message = "Documento (CPF/CNPJ) é obrigatório")
    @Size(min = 11, max = 100, message = "Documento (CPF/CNPJ) deve conter entre 2 e 100 caracteres")
    private String documentNumber;

    @NotEmpty(message = "Tipo Documento não pode ser nulo")
    @Size(min = 3, max = 4, message = "Tipo Documento deve conter entre 3 e 4 caracteres")
    private String documentType;

    @NotEmpty(message = "Senha não pode ser nula")
    @Size(min = 8, max = 16, message = "Senha deve conter entre 8 e 18 caracteres")
    private String password;

    @NotEmpty(message = "E-mail deve ser válido")
    @Size(min = 10, max = 120, message = "E-mail deve conter entre 10 e 120 caracteres")
    private String email;

    @NotEmpty(message = "Celular não pode ser nula")
    @Size(min = 11, max = 11, message = "Celular deve conter 11 caracteres ex: 11912357745")
    private String cellPhone;

    public static UserEntity getEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .document(userDTO.getDocumentNumber())
                .fullName(userDTO.getFullName())
                .documentType(userDTO.getDocumentType())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getCellPhone())
                .build();

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
                .documentType(userEntity.getDocumentType())
                .build();
    }

}
