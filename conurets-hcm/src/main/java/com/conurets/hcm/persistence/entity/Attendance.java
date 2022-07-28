package com.conurets.hcm.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "hcm_attendance")
@EqualsAndHashCode(callSuper = false)
public class Attendance extends BaseEntity {
    @Column(name = "str_enroll_number", length = 80)
    private String enrollNumber;

    @Column(name = "str_event_type", length = 80)
    private String eventType;

    @Column(name = "int_invalid")
    private Integer invalid;

    @Column(name = "int_att_state")
    private Integer attState;

    @Column(name = "int_verify_mode")
    private Integer verifyMode;

    @Column(name = "int_year")
    private Integer year;

    @Column(name = "int_month")
    private Integer month;

    @Column(name = "int_day")
    private Integer day;

    @Column(name = "int_hour")
    private Integer hour;

    @Column(name = "int_minute")
    private Integer minute;

    @Column(name = "int_second")
    private Integer second;

    @Column(name = "int_work_code")
    private Integer workCode;

    @Column(name = "int_sign_in")
    private Long signIn;

    @Column(name = "int_sign_out")
    private Long signOut;

    @Column(name = "int_duration")
    private Long duration;
}
