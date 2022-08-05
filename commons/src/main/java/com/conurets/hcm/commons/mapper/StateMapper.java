package com.conurets.hcm.commons.mapper;

import com.conurets.hcm.commons.base.dto.request.AddStateRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateStateRequestDTO;
import com.conurets.hcm.commons.base.dto.response.StateResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMHelper;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class StateMapper extends BaseMapper {
    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public State add(AddStateRequestDTO model) throws HCMException {
        State state = new State();
        state.setStatus(model.getStatus());
        state.setStateCode(model.getStateCode());
        state.setStateName(model.getStateName());
        state.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        addAuditingInformation(state);
        return state;
    }

    /**
     *
     * @param state
     * @return
     * @throws HCMException
     */

    public StateResponseDTO find(State state) throws HCMException{
        StateResponseDTO stateResponseDTO = new StateResponseDTO();
        stateResponseDTO.setStatus(HCMUtil.getStatus(state.getStatus()));
        stateResponseDTO.setStateId(state.getId());
        stateResponseDTO.setStateCode(state.getStateCode());
        stateResponseDTO.setStateName(state.getStateName());
        stateResponseDTO.setCountryId(state.getCountry().getId());
        return stateResponseDTO;
    }
    /**
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public State findStateById(long id) throws HCMException {
        State state = getDaoFactory().getStateDAO().findById(id);

        if (state == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        addAuditingInformation(state);

        return state;
    }


    /**
     *
     * @param model
     * @return
     * @throws HCMException
     */
    public State update(UpdateStateRequestDTO model) throws HCMException {
        State state = getDaoFactory().getStateDAO().findById(model.getStateId());

        if (state == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }
        state.setStatus(model.getStatus());
        state.setStateCode(model.getStateCode());
        state.setStateName(model.getStateName());
        state.setCountry(getDaoFactory().getCountryDAO().findById(model.getCountryId()));
        addAuditingInformation(state);
        return state;
    }
    /**
     *
     * @param id
     * @return
     * @throws HCMException
     */
    public State delete(long id) throws HCMException {
        State state = getDaoFactory().getStateDAO().findById(id);

        if (state == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        state.setStatus(HCMConstants.Common.STATUS_CODE_INACTIVE);

        addAuditingInformation(state);

        return state;
    }

}