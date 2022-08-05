package com.conurets.hcm.service.impl;

import com.conurets.hcm.commons.base.dto.request.AddCityRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCityRequestDTO;
import com.conurets.hcm.commons.base.dto.response.CityResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.City;
import com.conurets.hcm.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl extends BaseServiceImpl implements CityService {

    public CityResponseDTO add(AddCityRequestDTO model) throws HCMException {
        City city = getMapperFactory().getCityMapper().add(model);
        getDaoFactory().getCityDAO().save(city);
        CityResponseDTO cityResponseDTO = getMapperFactory().getCityMapper().find(city);
        return cityResponseDTO;
    }
    public List<CityResponseDTO> findAll() throws HCMException {
        List<CityResponseDTO> cityDTOList = new ArrayList<>();
        List<City> city = getDaoFactory().getCityDAO().findAllByKeyValue("status", 1);
        if (HCMUtil.isCollectionNotBlank(city)) {
            cityDTOList = city.stream()
                    .map(client -> getMapperFactory().getCityMapper().find(client))
                    .collect(Collectors.toList());
        }
        return cityDTOList;
    }
    public CityResponseDTO findById(int id) throws HCMException {
        City city = getMapperFactory().getCityMapper().findById(id);
        getDaoFactory().getCityDAO().update(city);
        CityResponseDTO cityResponseDTO = getMapperFactory().getCityMapper().find(city);
        return cityResponseDTO;
    }
    public CityResponseDTO update(UpdateCityRequestDTO model) throws HCMException {
        City city = getMapperFactory().getCityMapper().update(model);
        getDaoFactory().getCityDAO().update(city);
        CityResponseDTO cityResponseDTO = getMapperFactory().getCityMapper().find(city);
        return cityResponseDTO;

    }
    public CityResponseDTO delete(int id) throws HCMException {
        City city = getMapperFactory().getCityMapper().delete(id);
        getDaoFactory().getCityDAO().update(city);
        CityResponseDTO cityResponseDTO = getMapperFactory().getCityMapper().find(city);
        return cityResponseDTO;
    }






}
