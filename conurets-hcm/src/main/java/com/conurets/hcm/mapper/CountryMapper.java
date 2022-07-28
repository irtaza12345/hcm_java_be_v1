package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddCountryRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateCountryRequestDTO;
import com.conurets.hcm.base.dto.response.CountryResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.Country;
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

        country.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(country);

        return country;
    }

    /**
     *
     * @param user
     * @return
     * @throws HCMException
     */
    public CountryResponseDTO find(Country user) throws HCMException {
        CountryResponseDTO countryResponseDTO = new CountryResponseDTO();
        countryResponseDTO.setStatus(HCMUtil.getStatus(user.getStatus()));

        return countryResponseDTO;
    }
}