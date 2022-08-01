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
public class StateResponseDTO implements Serializable {
    private Long countryId;
    private Long stateId;
    private String stateName;
    private String stateCode;
    private String status;
}