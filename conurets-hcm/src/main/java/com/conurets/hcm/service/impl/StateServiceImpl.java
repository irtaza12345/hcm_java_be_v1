package com.conurets.hcm.service.impl;

import com.conurets.hcm.commons.base.dto.request.AddStateRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateStateRequestDTO;
import com.conurets.hcm.commons.base.dto.response.StateResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.State;
import com.conurets.hcm.service.StateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl extends BaseServiceImpl implements StateService {

    public StateResponseDTO add(AddStateRequestDTO model) throws HCMException {
        State state = getMapperFactory().getStateMapper().add(model);
        getDaoFactory().getStateDAO().save(state);
        StateResponseDTO stateResponseDTO = getMapperFactory().getStateMapper().find(state);
        return stateResponseDTO;
    }

    public List<StateResponseDTO> findAll() throws HCMException {
        List<StateResponseDTO> stateDTOList = new ArrayList<>();
        List<State> state = getDaoFactory().getStateDAO().findAllByKeyValue("status", 1);
        if (HCMUtil.isCollectionNotBlank(state)) {
            stateDTOList = state.stream()
                    .map(client -> getMapperFactory().getStateMapper().find(client))
                    .collect(Collectors.toList());
        }
        return stateDTOList;
    }
    public StateResponseDTO findById(int id) throws HCMException {
        State state = getMapperFactory().getStateMapper().findStateById(id);
        getDaoFactory().getStateDAO().update(state);
        StateResponseDTO stateResponseDTO = getMapperFactory().getStateMapper().find(state);
        return stateResponseDTO;
    }

    public StateResponseDTO update(UpdateStateRequestDTO model) throws HCMException {
        State state= getMapperFactory().getStateMapper().update(model);
        getDaoFactory().getStateDAO().update(state);
        StateResponseDTO stateResponseDTO = getMapperFactory().getStateMapper().find(state);
        return stateResponseDTO;

    }
    public StateResponseDTO delete(int id) throws HCMException {
        State state = getMapperFactory().getStateMapper().delete(id);
        getDaoFactory().getStateDAO().update(state);
        StateResponseDTO stateResponseDTO = getMapperFactory().getStateMapper().find(state);
        return stateResponseDTO;
    }

}
