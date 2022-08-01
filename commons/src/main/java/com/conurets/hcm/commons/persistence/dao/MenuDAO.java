package com.conurets.hcm.commons.persistence.dao;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.Menu;

import java.util.List;

/**
 * @author SHF
 * @version 1.0
 */

public interface MenuDAO extends BaseDAO<Menu> {
    List<Menu> findAllParentMenu() throws HCMException;

    List<Menu> findParentMenuByOrganizationId(long organizationId) throws HCMException;

    List<Menu> findMenuByOrganizationId(long organizationId) throws HCMException;
}