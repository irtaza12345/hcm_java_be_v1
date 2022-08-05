package com.conurets.hcm.service;

import com.conurets.hcm.commons.base.dto.request.AddOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.response.OrganizationResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;

import java.util.List;


public interface OrganizationService {
    OrganizationResponseDTO add(AddOrganizationRequestDTO model) throws HCMException;
    List<OrganizationResponseDTO> findAll() throws HCMException;
    OrganizationResponseDTO findById(int id) throws HCMException;
    OrganizationResponseDTO update (UpdateOrganizationRequestDTO model) throws HCMException;
    OrganizationResponseDTO delete(int id) throws HCMException;
}
