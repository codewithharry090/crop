package com.test.crop.service.impl;

import com.test.crop.dto.request.ConfigurationRequest;
import com.test.crop.dto.request.CountryRequest;
import com.test.crop.dto.response.ConfigurationResponse;
import com.test.crop.dto.response.CountryResponse;
import com.test.crop.entity.ConfigurationEntity;
import com.test.crop.entity.CountryEntity;
import com.test.crop.entity.CropEntity;
import com.test.crop.mapper.ConfigurationMapping;
import com.test.crop.mapper.CountryMapping;
import com.test.crop.repository.ConfigurationRepository;
import com.test.crop.repository.CountryRepository;
import com.test.crop.repository.CropRepository;
import com.test.crop.service.ConfigurationService;
import com.test.crop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CropRepository cropRepository;


    @Override
    public ConfigurationResponse createConfiguration(ConfigurationRequest configurationRequest) {

        CountryEntity countryEntity = countryRepository.findByCountryCode(configurationRequest.getCountryCode()).orElse(null);
        CropEntity cropEntity = cropRepository.findByCropCode(configurationRequest.getCropCode()).orElse(null);
        if(Objects.isNull(countryEntity) || Objects.isNull(cropEntity)){
            throw new EntityNotFoundException("country or crop not found");
        }

        ConfigurationEntity configurationEntity = ConfigurationMapping.requestToEntity(configurationRequest, countryEntity, cropEntity);
        return ConfigurationMapping.entityToResponse(configurationRepository.save(configurationEntity));
    }

    @Override
    public ConfigurationResponse getConfigurationByCountryCode(String countryCode) {
        ConfigurationEntity countryEntity = configurationRepository.findByCountryEntityCountryCode(countryCode).orElse(null);
        return ConfigurationMapping.entityToResponse(countryEntity);
    }

    @Override
    public ConfigurationResponse getConfigurationByCropCode(String cropCode) {
        ConfigurationEntity countryEntity = configurationRepository.findByCropEntityCropCode(cropCode).orElse(null);
        return ConfigurationMapping.entityToResponse(countryEntity);
    }

    @Override
    public List<ConfigurationResponse> getAllConfiguration() {
        List<ConfigurationEntity> configurationEntities = configurationRepository.findAll();
        return ConfigurationMapping.entityToResponseList(configurationEntities);
    }
}
