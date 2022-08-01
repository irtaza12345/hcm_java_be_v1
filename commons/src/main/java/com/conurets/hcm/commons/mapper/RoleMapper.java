package com.conurets.hcm.commons.mapper;

import com.conurets.hcm.commons.base.dto.request.AddRoleRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateRoleRequestDTO;
import com.conurets.hcm.commons.base.dto.response.RoleResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMHelper;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class RoleMapper extends BaseMapper {
    /**
     * Add role
     *
     * @param model
     * @throws HCMException
     */
    public Role addRole(AddRoleRequestDTO model) throws HCMException {
        String roleName = HCMUtil.createRoleName(model.getRoleName());

        Role role = new Role();
        role.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            role.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        role.setRoleName(roleName);
        role.setRoleDescription(model.getRoleDescription());
        role.setStatus(model.getStatus());

        addAuditingInformation(role);

        return role;
    }

    /**
     * Update role
     *
     * @param model
     * @throws HCMException
     */
    public Role updateRole(UpdateRoleRequestDTO model) throws HCMException {
        Role role = getDaoFactory().getRoleDAO().findById(model.getRoleId());

        if (role == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        String roleName = HCMUtil.createRoleName(model.getRoleName());

        role.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            role.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        role.setRoleName(roleName);
        role.setRoleDescription(model.getRoleDescription());
        role.setStatus(model.getStatus());

        addAuditingInformation(role);

        return role;
    }

    /**
     * Delete role
     *
     * @param id
     * @throws HCMException
     */
    public Role deleteRole(long id) throws HCMException {
        Role role = getDaoFactory().getRoleDAO().findById(id);

        if (role == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        role.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(role);

        return role;
    }

    /**
     * Find role
     *
     * @param role
     * @return
     * @throws HCMException
     */
    public RoleResponseDTO findRole(Role role) throws HCMException {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setOrganizationName(role.getOrganization().getName());

        if (role.getBranch() != null) {
            roleResponseDTO.setBranchName(role.getBranch().getName());
        }

        roleResponseDTO.setRoleId(role.getId());
        roleResponseDTO.setRoleName(role.getRoleName());
        roleResponseDTO.setRoleDescription(role.getRoleDescription());
        roleResponseDTO.setStatus(HCMUtil.getStatus(role.getStatus()));

        return roleResponseDTO;
    }
}