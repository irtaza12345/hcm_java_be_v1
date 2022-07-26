package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddPreferenceRequestDTO;
import com.conurets.hcm.base.dto.request.UpdatePreferenceRequestDTO;
import com.conurets.hcm.base.dto.response.PreferenceResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.Preference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class PreferenceMapper extends BaseMapper {
    /**
     * Add preference
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Preference add(AddPreferenceRequestDTO model) throws HCMException {
        Preference preference = new Preference();
        preference.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            preference.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        preference.setName(model.getName());
        preference.setValue(model.getValue());
        preference.setDescription(model.getDescription());
        preference.setStatus(model.getStatus());

        addAuditingInformation(preference);

        return preference;
    }

    /**
     * Update preference
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public Preference update(UpdatePreferenceRequestDTO model) throws HCMException {
        Preference preference = getDaoFactory().getPreferenceDAO().findById(model.getPreferenceId());

        if (preference == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        preference.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));

        if (model.getBranchId() != null) {
            preference.setBranch(getDaoFactory().getBranchDAO().findById(model.getBranchId()));
        }

        preference.setName(model.getName());
        preference.setValue(model.getValue());
        preference.setDescription(model.getDescription());
        preference.setStatus(model.getStatus());

        addAuditingInformation(preference);

        return preference;
    }

    /**
     * Delete preference
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public Preference delete(long id) throws HCMException {
        Preference preference = getDaoFactory().getPreferenceDAO().findById(id);

        if (preference == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        preference.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(preference);

        return preference;
    }

    /**
     * Find preference detail
     *
     * @param preference
     * @return
     * @throws HCMException
     */
    public PreferenceResponseDTO find(Preference preference) throws HCMException {
        PreferenceResponseDTO preferenceResponseDTO = new PreferenceResponseDTO();
        preferenceResponseDTO.setOrganizationId(preference.getOrganization().getId());
        preferenceResponseDTO.setOrganizationName(preference.getOrganization().getName());

        if (preference.getBranch() != null) {
            preferenceResponseDTO.setBranchId(preference.getBranch().getId());
            preferenceResponseDTO.setBranchName(preference.getBranch().getName());
        }

        preferenceResponseDTO.setPreferenceId(preference.getId());
        preferenceResponseDTO.setName(preference.getName());
        preferenceResponseDTO.setValue(preference.getValue());
        preferenceResponseDTO.setDescription(preference.getDescription());
        preferenceResponseDTO.setStatus(HCMUtil.getStatus(preference.getStatus()));

        return preferenceResponseDTO;
    }
}