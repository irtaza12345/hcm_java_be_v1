package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.Department;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface DepartmentDAO extends BaseDAO<Department> {
    List<Department> findByOrganizationId(long organizationId) throws HCMException;

    List<Department> findByBranchId(long branchId) throws HCMException;
}