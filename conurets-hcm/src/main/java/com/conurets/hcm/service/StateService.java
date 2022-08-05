package com.conurets.hcm.service;

import com.conurets.hcm.commons.base.dto.request.AddStateRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateStateRequestDTO;
import com.conurets.hcm.commons.base.dto.response.StateResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;

import java.util.List;

public interface StateService {
    StateResponseDTO add(AddStateRequestDTO model) throws HCMException;
    List<StateResponseDTO> findAll() throws HCMException;
    StateResponseDTO findById(int id) throws HCMException;
    StateResponseDTO update(UpdateStateRequestDTO model) throws HCMException;
    StateResponseDTO delete(int id) throws HCMException;
}
