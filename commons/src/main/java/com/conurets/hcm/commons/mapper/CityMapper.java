package com.conurets.hcm.commons.mapper;

import com.conurets.hcm.commons.base.dto.request.AddCityRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCityRequestDTO;
import com.conurets.hcm.commons.base.dto.response.CityResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMHelper;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class CityMapper extends BaseMapper {
    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public City add(AddCityRequestDTO model) throws HCMException {
        City city = new City();
        city.setStatus(model.getStatus());

        addAuditingInformation(city);

        return city;
    }

    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public City update(UpdateCityRequestDTO model) throws HCMException {
        City city = getDaoFactory().getCityDAO().findById(model.getCityId());

        if (city == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        city.setStatus(model.getStatus());

        addAuditingInformation(city);

        return city;
    }

    /**
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public City delete(long id) throws HCMException {
        City city = getDaoFactory().getCityDAO().findById(id);

        if (city == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        city.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(city);

        return city;
    }

    /**
     *
     * @param city
     * @return
     * @throws HCMException
     */
    public CityResponseDTO find(City city) throws HCMException {
        CityResponseDTO cityResponseDTO = new CityResponseDTO();
        cityResponseDTO.setStatus(HCMUtil.getStatus(city.getStatus()));

        return cityResponseDTO;
    }
}