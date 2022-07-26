package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddStateRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateStateRequestDTO;
import com.conurets.hcm.base.dto.response.StateResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.State;
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

        state.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(state);

        return state;
    }

    /**
     *
     * @param user
     * @return
     * @throws HCMException
     */
    public StateResponseDTO find(State user) throws HCMException {
        StateResponseDTO stateResponseDTO = new StateResponseDTO();
        stateResponseDTO.setStatus(HCMUtil.getStatus(user.getStatus()));

        return stateResponseDTO;
    }
}