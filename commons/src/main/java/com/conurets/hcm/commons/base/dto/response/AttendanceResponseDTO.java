package com.conurets.hcm.commons.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AttendanceResponseDTO implements Serializable {
    private String enrollNumber;
    private String eventType;
    private Date signIn;
    private Date signOut;
    private Integer invalid;
    private Integer attState;
    private Integer verifyMode;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer second;
    private Integer workCode;
    private String status;
}
