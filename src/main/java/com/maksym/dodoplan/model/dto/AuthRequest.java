package com.maksym.dodoplan.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AuthRequest {

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String email;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    private String password;

}
