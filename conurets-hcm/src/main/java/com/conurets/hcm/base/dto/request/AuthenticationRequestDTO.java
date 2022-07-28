package com.conurets.hcm.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthenticationRequestDTO implements Serializable {
    @NotEmpty(message = "Origin must not be empty")
    @Size(min = 1, max = 10, message = "Origin must have valid format")
    private String origin;
    @NotEmpty(message = "Email address must not be empty")
    @Size(min = 1, max = 80, message = "Email address must have valid format")
    private String emailAddress;
    @NotEmpty(message = "Password must not be empty")
    @Size(min = 1, max = 80, message = "Password must have valid format")
    private String password;
}
