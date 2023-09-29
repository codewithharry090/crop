package com.test.crop.service;

import com.test.crop.dto.request.ConfigurationRequest;
import com.test.crop.dto.request.CountryRequest;
import com.test.crop.dto.response.ConfigurationResponse;
import com.test.crop.dto.response.CountryResponse;

import java.util.List;

public interface ConfigurationService {

    ConfigurationResponse createConfiguration(ConfigurationRequest configurationRequest);

    ConfigurationResponse getConfigurationByCountryCode(String countryCode);

    ConfigurationResponse getConfigurationByCropCode(String cropCode);

    List<ConfigurationResponse> getAllConfiguration();
}
