package com.conurets.hcm.service.impl;

import com.conurets.hcm.commons.base.dto.request.AddOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.response.OrganizationResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.Organization;
import com.conurets.hcm.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl extends BaseServiceImpl implements OrganizationService {


    public OrganizationResponseDTO add(AddOrganizationRequestDTO model) throws HCMException {
        Organization organization = getMapperFactory().getOrganizationMapper().add(model);
        getDaoFactory().getOrganizationDAO().save(organization);
        OrganizationResponseDTO organizationResponseDTO = getMapperFactory().getOrganizationMapper().find(organization);
        return organizationResponseDTO;
    }

    public List<OrganizationResponseDTO> findAll() throws HCMException {
        List<OrganizationResponseDTO> organizationDTOList = new ArrayList<>();
        List<Organization> organization = getDaoFactory().getOrganizationDAO().findAllByKeyValue("status", 1);
        if (HCMUtil.isCollectionNotBlank(organization)) {
            organizationDTOList = organization.stream()
                    .map(client -> getMapperFactory().getOrganizationMapper().find(client))
                    .collect(Collectors.toList());
        }
        return organizationDTOList;
    }
    public OrganizationResponseDTO findById(int id) throws HCMException {
        Organization organization = getMapperFactory().getOrganizationMapper().findById(id);
        getDaoFactory().getOrganizationDAO().update(organization);
        OrganizationResponseDTO organizationResponseDTO = getMapperFactory().getOrganizationMapper().find(organization);
        return organizationResponseDTO;
    }
    public OrganizationResponseDTO update(UpdateOrganizationRequestDTO model) throws HCMException {
        Organization organization = getMapperFactory().getOrganizationMapper().update(model);
        getDaoFactory().getOrganizationDAO().update(organization);
        OrganizationResponseDTO organizationResponseDTO = getMapperFactory().getOrganizationMapper().find(organization);
        return organizationResponseDTO;

    }
    public OrganizationResponseDTO delete(int id) throws HCMException {
        Organization organization = getMapperFactory().getOrganizationMapper().delete(id);
        getDaoFactory().getOrganizationDAO().update(organization);
        OrganizationResponseDTO organizationResponseDTO = getMapperFactory().getOrganizationMapper().find(organization);
        return organizationResponseDTO;
    }



}
