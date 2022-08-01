package com.conurets.hcm.commons.base.dto.request;

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
public class UpdateBranchRequestDTO extends BaseRequestDTO {
    @NotEmpty(message = "Branch name must not be empty")
    @Size(min = 1, max = 80, message = "Branch name must have valid format")
    private String branchName;
    @NotEmpty(message = "Branch code must not be empty")
    @Size(min = 1, max = 80, message = "Branch code must have valid format")
    private String branchCode;
    @NotEmpty(message = "Address must not be empty")
    @Size(min = 1, max = 80, message = "Address must have valid format")
    private String address;
    @NotEmpty(message = "Phone number 1 must not be empty")
    @Size(min = 1, max = 80, message = "Phone number 1 must have valid format")
    private String phoneNumber1;
    private String phoneNumber2;
    @NotEmpty(message = "Email address must not be empty")
    @Size(min = 1, max = 80, message = "Email address must have valid format")
    private String emailAddress;
    private String postalCode;
    @NotNull(message = "Country ID must not be null")
    private Long countryId;
    @NotNull(message = "State ID must not be null")
    private Long stateId;
    @NotNull(message = "City ID must not be null")
    private Long cityId;
    private String region;
    @NotNull(message = "Status must not be null")
    private Integer status;
}