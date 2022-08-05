package com.conurets.hcm.service;

import com.conurets.hcm.commons.base.dto.request.AddCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.response.CountryResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;

import java.util.List;

public interface CountryService {

    CountryResponseDTO add(AddCountryRequestDTO model) throws HCMException;
    List<CountryResponseDTO> findAll() throws HCMException;
    CountryResponseDTO findById(int id) throws HCMException;
    CountryResponseDTO update(UpdateCountryRequestDTO model) throws HCMException;
    CountryResponseDTO delete(int id) throws HCMException;

}

