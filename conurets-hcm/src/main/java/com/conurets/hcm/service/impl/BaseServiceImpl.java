package com.conurets.hcm.service.impl;

import com.conurets.hcm.mapper.factory.MapperFactory;
import com.conurets.hcm.persistence.factory.DAOFactory;
import com.conurets.hcm.security.factory.JwtFactory;
import com.conurets.hcm.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Getter
public abstract class BaseServiceImpl implements BaseService {
    @Autowired
    private DAOFactory daoFactory;
    @Autowired
    private MapperFactory mapperFactory;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtFactory jwtFactory;
}
