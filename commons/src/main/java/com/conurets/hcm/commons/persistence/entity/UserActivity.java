package com.conurets.hcm.commons.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "hcm_user_activities")
@EqualsAndHashCode(callSuper = false)
public class UserActivity extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "str_service_name", nullable = false, length = 200)
    private String serviceName;

    @Column(name = "str_request", nullable = false, length = 200)
    private String request;

    @Column(name = "str_request_data", nullable = false, length = 4096)
    private String requestData;
}