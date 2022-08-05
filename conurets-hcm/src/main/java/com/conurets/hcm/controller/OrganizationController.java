package com.conurets.hcm.controller;

import com.conurets.hcm.commons.base.dto.request.AddOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateOrganizationRequestDTO;
import com.conurets.hcm.commons.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.commons.base.dto.response.OrganizationResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController extends BaseController{

    @ResponseBody
    @PostMapping(value = "/add")
    public ResponseEntity<OrganizationResponseDTO> add(@Valid @RequestBody AddOrganizationRequestDTO model) throws HCMException {
        OrganizationResponseDTO organizationResponseDTO =  getServiceFactory().getOrganizationService().add(model);
        return  ResponseEntity.ok(organizationResponseDTO);
    }

    @GetMapping(value = "/find-all")
    public BaseResponseDTO findAll() throws HCMException {
        List<OrganizationResponseDTO> dtoList = getServiceFactory().getOrganizationService().findAll();
        return response(dtoList);
    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<OrganizationResponseDTO> findById(@PathVariable int id) throws HCMException
    {
        OrganizationResponseDTO organizationResponseDTO =  getServiceFactory().getOrganizationService().findById(id) ;
        return  ResponseEntity.ok(organizationResponseDTO);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<OrganizationResponseDTO> update(@Valid @RequestBody UpdateOrganizationRequestDTO model) throws HCMException
    {
        OrganizationResponseDTO organizationResponseDTO =  getServiceFactory().getOrganizationService().update(model) ;
        return  ResponseEntity.ok(organizationResponseDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<OrganizationResponseDTO> delete(@PathVariable int id) throws HCMException
    {
        OrganizationResponseDTO organizationResponseDTO =  getServiceFactory().getOrganizationService().delete(id) ;
        return  ResponseEntity.ok(organizationResponseDTO);
    }


}
