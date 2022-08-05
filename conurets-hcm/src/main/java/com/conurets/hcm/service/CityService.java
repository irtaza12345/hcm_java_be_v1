package com.conurets.hcm.service;

import com.conurets.hcm.commons.base.dto.request.AddCityRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCityRequestDTO;
import com.conurets.hcm.commons.base.dto.response.CityResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;

import java.util.List;

public interface CityService {
    CityResponseDTO add(AddCityRequestDTO model) throws HCMException;
    List<CityResponseDTO> findAll() throws HCMException;
    CityResponseDTO findById(int id) throws HCMException;
    CityResponseDTO update(UpdateCityRequestDTO model) throws HCMException;
    CityResponseDTO delete(int id) throws HCMException;
}
