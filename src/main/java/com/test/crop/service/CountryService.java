package com.test.crop.service;

import com.test.crop.dto.request.CountryRequest;
import com.test.crop.dto.response.CountryResponse;

import java.util.List;

public interface CountryService {
    CountryResponse createCountry(CountryRequest countryRequest);

    CountryResponse getCountryById(String countryCode);

    List<CountryResponse> getAllCountry();
}
