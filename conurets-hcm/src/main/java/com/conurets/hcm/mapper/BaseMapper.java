package com.conurets.hcm.mapper;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMDateUtil;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.persistence.entity.BaseEntity;
import com.conurets.hcm.persistence.factory.DAOFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Getter
public abstract class BaseMapper {
    @Autowired
    private DAOFactory daoFactory;

    @PostConstruct
    public void init() {
        HCMHelper.checkConfiguration(daoFactory, "daoFactory");
    }

    /**
     * Set created by, created date, last update by and last update date fields
     *
     * @param object
     * @throws HCMException
     */
    protected final void addAuditingInformation(BaseEntity object) throws HCMException {
        if (object.getId() == null) {
            object.setCreatedDate(HCMDateUtil.getCurrentTimestamp());
            object.setCreatedBy(1L);
        } else {
            object.setLastUpdate(HCMDateUtil.getCurrentTimestamp());
            object.setLastUpdateBy(1L);
        }
    }
}