package com.conurets.hcm.commons.base.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class CountryResponseDTO implements Serializable {
    private Long countryId;
    private String countryName;
    private String countryCode;
    private String status;
}