package com.conurets.hcm.service.impl;

import com.conurets.hcm.commons.base.dto.request.AddCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.response.CountryResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.Country;
import com.conurets.hcm.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl extends BaseServiceImpl implements CountryService {

    public CountryResponseDTO add(AddCountryRequestDTO model) throws HCMException {
        Country country = getMapperFactory().getCountryMapper().add(model);
        getDaoFactory().getCountryDAO().save(country);
        CountryResponseDTO countryResponseDTO = getMapperFactory().getCountryMapper().find(country);
        return countryResponseDTO;
    }

    public List<CountryResponseDTO> findAll() throws HCMException {
        List<CountryResponseDTO> countryDTOList = new ArrayList<>();
        List<Country> countries = getDaoFactory().getCountryDAO().findAllByKeyValue("status", 1);
        if (HCMUtil.isCollectionNotBlank(countries)) {
            countryDTOList = countries.stream()
                    .map(client -> getMapperFactory().getCountryMapper().find(client))
                    .collect(Collectors.toList());
        }
        return countryDTOList;
    }
    public CountryResponseDTO findById(int id) throws HCMException {
        Country country = getMapperFactory().getCountryMapper().findById(id);
        getDaoFactory().getCountryDAO().update(country);
        CountryResponseDTO countryResponseDTO = getMapperFactory().getCountryMapper().find(country);
        return countryResponseDTO;
    }



    public CountryResponseDTO update(UpdateCountryRequestDTO model) throws HCMException {
        Country country = getMapperFactory().getCountryMapper().update(model);
        getDaoFactory().getCountryDAO().update(country);
        CountryResponseDTO countryResponseDTO = getMapperFactory().getCountryMapper().find(country);
        return countryResponseDTO;

    }
    public CountryResponseDTO delete(int id) throws HCMException {
        Country country = getMapperFactory().getCountryMapper().delete(id);
        getDaoFactory().getCountryDAO().update(country);
        CountryResponseDTO countryResponseDTO = getMapperFactory().getCountryMapper().find(country);
        return countryResponseDTO;
    }

}