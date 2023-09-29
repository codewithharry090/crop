package com.test.crop.controller;

import com.test.crop.dto.request.ConfigurationRequest;
import com.test.crop.dto.response.ConfigurationResponse;
import com.test.crop.service.ConfigurationService;
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
@RequestMapping("/v1/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @PostMapping
    public ResponseEntity<ConfigurationResponse> createConfiguration(@Valid @NotNull @RequestBody ConfigurationRequest  configurationRequest){
        return ResponseEntity.ok(configurationService.createConfiguration(configurationRequest));
    }

    @GetMapping("/country/{countryCode}")
    public ResponseEntity<ConfigurationResponse> getConfigurationByCountryCode(@Valid @NotNull @PathVariable("countryCode") String countryCode){
        return ResponseEntity.ok(configurationService.getConfigurationByCountryCode(countryCode));
    }

    @GetMapping("/crop/{cropCode}")
    public ResponseEntity<ConfigurationResponse> getConfigurationByCropCode(@Valid @NotNull @PathVariable("cropCode") String cropCode){
        return ResponseEntity.ok(configurationService.getConfigurationByCropCode(cropCode));
    }

    @GetMapping
    public ResponseEntity<List<ConfigurationResponse>> getAllConfiguration(){
        return ResponseEntity.ok(configurationService.getAllConfiguration());
    }


}
