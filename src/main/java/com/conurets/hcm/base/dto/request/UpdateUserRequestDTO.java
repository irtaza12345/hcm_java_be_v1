package com.conurets.hcm.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateUserRequestDTO extends BaseRequestDTO {
    @NotNull(message = "User ID must not be null")
    private Long userId;
    @NotEmpty(message = "First name must not be empty")
    @Size(min = 1, max = 80, message = "First name must have valid format")
    private String firstName;
    @NotEmpty(message = "Last name must not be empty")
    @Size(min = 1, max = 80, message = "Last name must have valid format")
    private String lastName;
    @NotEmpty(message = "Email address must not be empty")
    @Size(min = 1, max = 80, message = "Email address must have valid format")
    private String emailAddress;
    @NotEmpty(message = "Mobile number must not be empty")
    @Size(min = 1, max = 20, message = "Mobile number must have valid format")
    private String mobileNumber;
    @NotEmpty(message = "Designation must not be empty")
    @Size(min = 1, max = 80, message = "Designation must have valid format")
    private String designation;
    @NotNull(message = "User Type ID must not be null")
    private Long userTypeId;
    @NotNull(message = "Country ID Last name must not be null")
    private Long countryId;
    @NotNull(message = "State ID Last name must not be null")
    private Long stateId;
    @NotNull(message = "City ID Last name must not be null")
    private Long cityId;
    private Boolean defaultUser;
    private Integer status;
}