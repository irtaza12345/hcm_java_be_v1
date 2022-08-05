package com.conurets.hcm.controller;

import com.conurets.hcm.commons.base.dto.request.AddStateRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateStateRequestDTO;
import com.conurets.hcm.commons.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.commons.base.dto.response.StateResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/api/state")
public class StateController extends BaseController {

    @ResponseBody
    @PostMapping(value = "/add")
    public ResponseEntity<StateResponseDTO> add(@Valid @RequestBody AddStateRequestDTO model) throws HCMException {
        StateResponseDTO stateResponseDTO =  getServiceFactory().getStateService().add(model);
        return  ResponseEntity.ok(stateResponseDTO);
    }

    @GetMapping(value = "/find-all")
    public BaseResponseDTO findAll() throws HCMException {
        List<StateResponseDTO> dtoList = getServiceFactory().getStateService().findAll();
        return response(dtoList);
    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<StateResponseDTO> findById(@PathVariable int id) throws HCMException
    {
        StateResponseDTO stateResponseDTO =  getServiceFactory().getStateService().findById(id) ;
        return  ResponseEntity.ok(stateResponseDTO);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<StateResponseDTO> update(@Valid @RequestBody UpdateStateRequestDTO model) throws HCMException
    {
        StateResponseDTO stateResponseDTO =  getServiceFactory().getStateService().update(model) ;
        return  ResponseEntity.ok(stateResponseDTO);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<StateResponseDTO> delete(@PathVariable int id) throws HCMException
    {
        StateResponseDTO stateResponseDTO =  getServiceFactory().getStateService().delete(id) ;
        return  ResponseEntity.ok(stateResponseDTO);
    }



}
