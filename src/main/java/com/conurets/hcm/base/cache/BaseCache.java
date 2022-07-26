package com.conurets.hcm.base.cache;

import com.conurets.hcm.persistence.factory.DAOFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Getter
public class BaseCache {
    @Autowired
    private DAOFactory daoFactory;
}
