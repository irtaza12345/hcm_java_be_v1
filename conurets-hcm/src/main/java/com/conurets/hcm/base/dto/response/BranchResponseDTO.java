package com.conurets.hcm.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BranchResponseDTO implements Serializable {
    private String organizationName;
    private String companyName;
    private Long branchId;
    private String branchName;
    private String name;
    private String branchCode;
    private String address;
    private String phoneNumber1;
    private String phoneNumber2;
    private String emailAddress;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String region;
    private String status;
}