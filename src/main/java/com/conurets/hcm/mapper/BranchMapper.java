package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddBranchRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateBranchRequestDTO;
import com.conurets.hcm.base.dto.response.BranchResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.Branch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class BranchMapper extends BaseMapper {
    /**
     * @param model
     * @return
     * @throws HCMException
     */
    public Branch add(AddBranchRequestDTO model) throws HCMException {
        Branch branch = new Branch();
        branch.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));
        branch.setName(model.getName());
        branch.setBranchCode(model.getBranchCode());
        branch.setAddress(model.getAddress());
        branch.setEmailAddress(model.getEmailAddress());
        branch.setPhoneNumber1(model.getPhoneNumber1());
        branch.setPhoneNumber2(model.getPhoneNumber2());
        branch.setPostalCode(model.getPostalCode());

        if (model.getCountryId() != null) {
            branch.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        }

        if (model.getStateId() != null) {
            branch.setState(getDaoFactory().getStateDAO().findById(model.getStateId()));
        }

        if (model.getCityId() != null) {
            branch.setCity(getDaoFactory().getCityDAO().findById(model.getCityId()));
        }

        branch.setRegion(model.getRegion());
        branch.setStatus(model.getStatus());

        addAuditingInformation(branch);

        return branch;
    }

    /**
     * @param model
     * @return
     * @throws HCMException
     */
    public Branch update(UpdateBranchRequestDTO model) throws HCMException {
        Branch branch = getDaoFactory().getBranchDAO().findById(model.getBranchId());

        if (branch == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        branch.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getBranchId()));
        branch.setName(model.getBranchName());
        branch.setBranchCode(model.getBranchCode());
        branch.setAddress(model.getAddress());
        branch.setEmailAddress(model.getEmailAddress());
        branch.setPhoneNumber1(model.getPhoneNumber1());
        branch.setPhoneNumber2(model.getPhoneNumber2());
        branch.setPostalCode(model.getPostalCode());

        if (model.getCountryId() != null) {
            branch.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        }

        if (model.getStateId() != null) {
            branch.setState(getDaoFactory().getStateDAO().findById(model.getStateId()));
        }

        if (model.getCityId() != null) {
            branch.setCity(getDaoFactory().getCityDAO().findById(model.getCityId()));
        }

        branch.setRegion(model.getRegion());
        branch.setStatus(model.getStatus());

        addAuditingInformation(branch);

        return branch;
    }

    /**
     * @param id
     * @return
     * @throws HCMException
     */
    public Branch delete(long id) throws HCMException {
        Branch branch = getDaoFactory().getBranchDAO().findById(id);

        if (branch == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        branch.setStatus(HCMConstants.Common.STATUS_CODE_ACTIVE);

        addAuditingInformation(branch);

        return branch;
    }

    /**
     * @param branch
     * @return
     * @throws HCMException
     */
    public BranchResponseDTO find(Branch branch) throws HCMException {
        BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
        branchResponseDTO.setOrganizationName(branch.getOrganization().getName());
        branchResponseDTO.setBranchId(branch.getId());
        branchResponseDTO.setBranchName(branch.getName());
        branchResponseDTO.setBranchCode(branch.getBranchCode());
        branchResponseDTO.setAddress(branch.getAddress());
        branchResponseDTO.setEmailAddress(branch.getEmailAddress());
        branchResponseDTO.setPhoneNumber1(branch.getPhoneNumber1());
        branchResponseDTO.setPhoneNumber2(branch.getPhoneNumber2());
        branchResponseDTO.setPostalCode(branch.getPostalCode());

        if (branch.getCountry() != null) {
            branchResponseDTO.setCountry(branch.getCountry().getCountryName());
        }

        if (branch.getState() != null) {
            branchResponseDTO.setState(branch.getState().getStateName());
        }

        if (branch.getCity() != null) {
            branchResponseDTO.setCity(branch.getCity().getCityName());
        }

        branchResponseDTO.setRegion(branch.getRegion());
        branchResponseDTO.setStatus(HCMUtil.getStatus(branch.getStatus()));

        return branchResponseDTO;
    }
}