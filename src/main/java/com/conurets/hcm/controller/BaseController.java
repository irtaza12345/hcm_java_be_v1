package com.conurets.hcm.controller;

import com.conurets.hcm.base.response.entity.BaseResponseEntity;
import com.conurets.hcm.service.factory.ServiceFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Getter
public abstract class BaseController extends BaseResponseEntity {
    @Autowired
    private ServiceFactory serviceFactory;
}
