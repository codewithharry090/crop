package com.test.crop.mapper;

import com.test.crop.dto.request.ConfigurationRequest;
import com.test.crop.dto.response.ConfigurationResponse;
import com.test.crop.entity.ConfigurationEntity;
import com.test.crop.entity.CountryEntity;
import com.test.crop.entity.CropEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConfigurationMapping {
    public static ConfigurationEntity requestToEntity(ConfigurationRequest configurationRequest,
                                                      CountryEntity countryEntity, CropEntity cropEntity) {
        if (Objects.isNull(configurationRequest)) return null;
        return ConfigurationEntity.builder()
                .countryEntity(countryEntity)
                .cropEntity(cropEntity)
                .build();

    }

    public static ConfigurationResponse entityToResponse(ConfigurationEntity configurationEntity) {
        if (Objects.isNull(configurationEntity)) return null;
        return ConfigurationResponse.builder()
                .id(configurationEntity.getId())
                .countryCode(configurationEntity.getCountryEntity().getCountryCode())
                .cropCode(configurationEntity.getCropEntity().getCropCode())
                .build();
    }


    public static List<ConfigurationResponse> entityToResponseList(List<ConfigurationEntity> configurationEntities) {
        if (Objects.isNull(configurationEntities)) return null;
        return configurationEntities.stream().map(ConfigurationMapping::entityToResponse).collect(Collectors.toList());
    }
}
