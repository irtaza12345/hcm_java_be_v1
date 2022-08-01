package com.conurets.hcm.commons.mapper;

import com.conurets.hcm.commons.base.dto.request.AddDepartmentRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateDepartmentRequestDTO;
import com.conurets.hcm.commons.base.dto.response.DepartmentResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMHelper;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class DepartmentMapper extends BaseMapper {
    /**
     * Add department
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Department add(AddDepartmentRequestDTO model) throws HCMException {
        Department department = new Department();
        department.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            department.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        department.setDepartmentCode(model.getDepartmentCode());
        department.setDepartmentName(model.getDepartmentName());
        department.setStatus(model.getStatus());

        addAuditingInformation(department);

        return department;
    }

    /**
     * Update department
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Department update(UpdateDepartmentRequestDTO model) throws HCMException {
        Department department = getDaoFactory().getDepartmentDAO().findById(model.getDepartmentId());

        if (department == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        department.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            department.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        department.setDepartmentCode(model.getDepartmentCode());
        department.setDepartmentName(model.getDepartmentName());
        department.setStatus(model.getStatus());

        addAuditingInformation(department);

        return department;
    }

    /**
     * Delete department
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public Department delete(long id) throws HCMException {
        Department department = getDaoFactory().getDepartmentDAO().findById(id);

        if (department == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        department.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(department);

        return department;
    }

    /**
     * Find department
     *
     * @param employee
     * @return
     * @throws HCMException
     */
    public DepartmentResponseDTO find(Department employee) throws HCMException {
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        departmentResponseDTO.setOrganizationName(employee.getOrganization().getName());
        departmentResponseDTO.setBranchName(employee.getBranch().getName());
        departmentResponseDTO.setDepartmentId(employee.getId());
        departmentResponseDTO.setDepartmentCode(employee.getDepartmentCode());
        departmentResponseDTO.setDepartmentName(employee.getDepartmentName());
        departmentResponseDTO.setStatus(HCMUtil.getStatus(employee.getStatus()));

        return departmentResponseDTO;
    }
}