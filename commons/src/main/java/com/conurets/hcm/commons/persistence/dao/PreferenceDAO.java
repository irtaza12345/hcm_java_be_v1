package com.conurets.hcm.commons.persistence.dao;

import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.persistence.entity.Preference;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface PreferenceDAO extends BaseDAO<Preference> {
    List<Preference> findByOrganizationId(long organizationId) throws HCMException;

    List<Preference> findByBranchId(long branchId) throws HCMException;
}