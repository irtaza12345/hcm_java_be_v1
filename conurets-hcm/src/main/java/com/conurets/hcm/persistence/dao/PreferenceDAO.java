package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.Preference;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface PreferenceDAO extends BaseDAO<Preference> {
    List<Preference> findByOrganizationId(long organizationId) throws HCMException;

    List<Preference> findByBranchId(long branchId) throws HCMException;
}