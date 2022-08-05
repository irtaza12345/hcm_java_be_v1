package com.conurets.hcm.commons.mapper;

import com.conurets.hcm.commons.base.dto.request.AddCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.response.CountryResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMHelper;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class CountryMapper extends BaseMapper {
    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Country add(AddCountryRequestDTO model) throws HCMException {
        Country country = new Country();
        country.setStatus(model.getStatus());
        country.setCountryCode(model.getCountryCode());
        country.setCountryName(model.getCountryName());
        addAuditingInformation(country);
        return country;
    }
    /**
     *
     * @param country
     * @return
     * @throws HCMException
     */
    public CountryResponseDTO find(Country country) throws HCMException {
        return CountryResponseDTO.builder()
                .countryId(country.getId())
                .countryCode(country.getCountryCode())
                .countryName(country.getCountryName())
                .status(HCMUtil.getStatus(country.getStatus()))
                .build();
    }


    /**
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public Country findById(long id) throws HCMException {
        Country country = getDaoFactory().getCountryDAO().findById(id);

        if (country == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }
        addAuditingInformation(country);

        return country;
    }

    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Country update(UpdateCountryRequestDTO model) throws HCMException {
        Country country = getDaoFactory().getCountryDAO().findById(model.getCountryId());

        if (country == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }
        country.setStatus(model.getStatus());
        country.setCountryCode(model.getCountryCode());
        country.setCountryName(model.getCountryName());
        addAuditingInformation(country);
        return country;
    }

    /**
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public Country delete(long id) throws HCMException {
        Country country = getDaoFactory().getCountryDAO().findById(id);

        if (country == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        country.setStatus(HCMConstants.Common.STATUS_CODE_INACTIVE);

        addAuditingInformation(country);

        return country;
    }


}