package com.conurets.hcm.commons.mapper;

import com.conurets.hcm.commons.base.dto.request.AddOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.response.OrganizationResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMHelper;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.Organization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class OrganizationMapper extends BaseMapper {
    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Organization add(AddOrganizationRequestDTO model) throws HCMException {
        Organization organization = new Organization();
        organization.setName(model.getName());
        organization.setAddress(model.getAddress());
        organization.setEmailAddress(model.getEmailAddress());
        organization.setPhoneNumber1(model.getPhoneNumber1());
        organization.setPhoneNumber2(model.getPhoneNumber2());
        organization.setPostalCode(model.getPostalCode());
        organization.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        organization.setState(getDaoFactory().getStateDAO().findById(model.getStateId()));
        organization.setCity(getDaoFactory().getCityDAO().findById(model.getCityId()));
        organization.setStatus(model.getStatus());

        addAuditingInformation(organization);

        return organization;
    }

    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Organization update(UpdateOrganizationRequestDTO model) throws HCMException {
        Organization organization = getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId());

        if (organization == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        organization.setName(model.getName());
        organization.setAddress(model.getAddress());
        organization.setEmailAddress(model.getEmailAddress());
        organization.setPhoneNumber1(model.getPhoneNumber1());
        organization.setPhoneNumber2(model.getPhoneNumber2());
        organization.setPostalCode(model.getPostalCode());
        organization.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        organization.setState(getDaoFactory().getStateDAO().findById(model.getStateId()));
        organization.setCity(getDaoFactory().getCityDAO().findById(model.getCityId()));
        organization.setStatus(model.getStatus());

        addAuditingInformation(organization);

        return organization;
    }

    /**
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public Organization delete(long id) throws HCMException {
        Organization organization = getDaoFactory().getOrganizationDAO().findById(id);

        if (organization == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        organization.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(organization);

        return organization;
    }

    /**
     *
     * @param organization
     * @return
     * @throws HCMException
     */
    public OrganizationResponseDTO find(Organization organization) throws HCMException {
        OrganizationResponseDTO organizationResponseDTO = new OrganizationResponseDTO();
        organizationResponseDTO.setOrganizationId(organization.getId());
        organizationResponseDTO.setName(organization.getName());
        organizationResponseDTO.setAddress(organization.getAddress());
        organizationResponseDTO.setEmailAddress(organization.getEmailAddress());
        organizationResponseDTO.setPhoneNumber1(organization.getPhoneNumber1());
        organizationResponseDTO.setPhoneNumber2(organization.getPhoneNumber2());
        organizationResponseDTO.setPostalCode(organization.getPostalCode());
        organizationResponseDTO.setCountry(organization.getCountry().getCountryName());
        organizationResponseDTO.setState(organization.getState().getStateName());
        organizationResponseDTO.setCity(organization.getCity().getCityName());
        organizationResponseDTO.setStatus(HCMUtil.getStatus(organization.getStatus()));

        return organizationResponseDTO;
    }
}