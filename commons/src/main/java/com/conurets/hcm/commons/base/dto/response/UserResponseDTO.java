package com.conurets.hcm.commons.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponseDTO implements Serializable {
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;
    private String country;
    private String state;
    private String city;
    private String designation;
    private String status;
    private String organizationName;
    private String companyName;
    private String branchName;
}