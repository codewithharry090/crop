package com.test.crop.controller;

import com.test.crop.dto.request.CountryRequest;
import com.test.crop.dto.response.CountryResponse;
import com.test.crop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryResponse> createCountry(@Valid @NotNull @RequestBody CountryRequest countryRequest){
        return ResponseEntity.ok(countryService.createCountry(countryRequest));
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<CountryResponse> getCountryById(@Valid @NotNull @PathVariable("countryCode") String countryCode){
        return ResponseEntity.ok(countryService.getCountryById(countryCode));
    }

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAllCountry(){
        return ResponseEntity.ok(countryService.getAllCountry());
    }
}
