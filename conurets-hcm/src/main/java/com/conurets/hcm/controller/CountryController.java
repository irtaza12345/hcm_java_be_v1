package com.conurets.hcm.controller;

import com.conurets.hcm.commons.base.dto.request.AddCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.request.UpdateCountryRequestDTO;
import com.conurets.hcm.commons.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.commons.base.dto.response.CountryResponseDTO;
import com.conurets.hcm.commons.base.exception.HCMException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController extends BaseController {


    @ResponseBody
    @PostMapping(value = "/add")
    public ResponseEntity<CountryResponseDTO> add(@Valid @RequestBody AddCountryRequestDTO model) throws HCMException {
        CountryResponseDTO countryResponseDTO =  getServiceFactory().getCountryService().add(model);
        return  ResponseEntity.ok(countryResponseDTO);
    }

    @GetMapping(value = "/find-all")
    public BaseResponseDTO findAll() throws HCMException {
        List<CountryResponseDTO> dtoList = getServiceFactory().getCountryService().findAll();
        return response(dtoList);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<CountryResponseDTO> findById(@PathVariable  int id) throws HCMException
    {
        CountryResponseDTO countryResponseDTO =  getServiceFactory().getCountryService().findById(id) ;
        return  ResponseEntity.ok(countryResponseDTO);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CountryResponseDTO> update(@Valid @RequestBody UpdateCountryRequestDTO model) throws HCMException
    {
        CountryResponseDTO countryResponseDTO =  getServiceFactory().getCountryService().update(model) ;
        return  ResponseEntity.ok(countryResponseDTO);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<CountryResponseDTO> delete(@PathVariable int id) throws HCMException
    {
        CountryResponseDTO countryResponseDTO =  getServiceFactory().getCountryService().delete(id) ;
        return  ResponseEntity.ok(countryResponseDTO);
    }


}



