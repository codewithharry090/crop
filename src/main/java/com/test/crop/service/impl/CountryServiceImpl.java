package com.test.crop.service.impl;

import com.test.crop.dto.request.CountryRequest;
import com.test.crop.dto.response.CountryResponse;
import com.test.crop.entity.CountryEntity;
import com.test.crop.mapper.CountryMapping;
import com.test.crop.repository.CountryRepository;
import com.test.crop.repository.CropRepository;
import com.test.crop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryResponse createCountry(CountryRequest countryRequest) {
        CountryEntity countryEntity = countryRepository.save(CountryMapping.requestToEntity(countryRequest));
        return CountryMapping.entityToResponse(countryEntity);
    }

    @Override
    public CountryResponse getCountryById(String countryCode) {
        CountryEntity countryEntity = countryRepository.findByCountryCode(countryCode).orElse(null);
        return CountryMapping.entityToResponse(countryEntity);
    }

    @Override
    public List<CountryResponse> getAllCountry() {
        List<CountryEntity> countryEntities = countryRepository.findAll();
        return CountryMapping.entityToResponseList(countryEntities);
    }
}
