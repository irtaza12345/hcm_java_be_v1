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
public class CityResponseDTO implements Serializable {
    private Long companyId;
    private String name;
    private String ntnNumber;
    private String stnNumber;
    private String address;
    private String phoneNumber1;
    private String phoneNumber2;
    private String emailAddress;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String status;
    private String organizationName;
    private String companyName;
    private String branchName;
}