package com.conurets.hcm.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class BaseResponseDTO<R> implements Serializable {
    private int code;
    private String value;
    private R data;
}