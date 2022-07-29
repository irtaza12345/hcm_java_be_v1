package com.conurets.hcm.commons.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AddAttendanceRequestDTO implements Serializable {
    private String enrollNumber;
    private String eventType;
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
    private Long signIn;
    private Long signOut;
}
