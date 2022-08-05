package com.conurets.hcm.controller;

import com.conurets.hcm.commons.base.dto.request.AddCityRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCityRequestDTO;
import com.conurets.hcm.commons.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.commons.base.dto.response.CityResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController extends BaseController {


    @ResponseBody
    @PostMapping(value = "/add")
    public ResponseEntity<CityResponseDTO> add(@Valid @RequestBody AddCityRequestDTO model) throws HCMException {
        CityResponseDTO cityResponseDTO = getServiceFactory().getCityService().add(model);
        return ResponseEntity.ok(cityResponseDTO);
    }
    @GetMapping(value = "/find-all")
    public BaseResponseDTO findAll() throws HCMException {
        List<CityResponseDTO> dtoList = getServiceFactory().getCityService().findAll();
        return response(dtoList);
    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<CityResponseDTO> findById(@PathVariable int id) throws HCMException
    {
        CityResponseDTO cityResponseDTO =  getServiceFactory().getCityService().findById(id) ;
        return  ResponseEntity.ok(cityResponseDTO);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CityResponseDTO> update(@Valid @RequestBody UpdateCityRequestDTO model) throws HCMException
    {
        CityResponseDTO cityResponseDTO =  getServiceFactory().getCityService().update(model) ;
        return  ResponseEntity.ok(cityResponseDTO);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<CityResponseDTO> delete(@PathVariable int id) throws HCMException
    {
        CityResponseDTO cityResponseDTO =  getServiceFactory().getCityService().delete(id) ;
        return  ResponseEntity.ok(cityResponseDTO);
    }



}