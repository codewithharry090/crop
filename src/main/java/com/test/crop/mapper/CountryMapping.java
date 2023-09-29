package com.test.crop.mapper;

import com.test.crop.dto.request.CountryRequest;
import com.test.crop.dto.request.CropRequest;
import com.test.crop.dto.response.CountryResponse;
import com.test.crop.dto.response.CropResponse;
import com.test.crop.entity.CountryEntity;
import com.test.crop.entity.CropEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountryMapping {
    public static CountryEntity requestToEntity(CountryRequest countryRequest) {
        if (Objects.isNull(countryRequest)) return null;
        return CountryEntity.builder()
                .countryName(countryRequest.getCountryName())
                .countryCode(countryRequest.getCountryCode())
                .build();

    }

    public static CountryResponse entityToResponse(CountryEntity countryEntity) {
        if (Objects.isNull(countryEntity)) return null;
        return CountryResponse.builder()
                .id(countryEntity.getId())
                .countryName(countryEntity.getCountryName())
                .countryCode(countryEntity.getCountryCode())
                .build();
    }


    public static List<CountryResponse> entityToResponseList(List<CountryEntity> countryEntities) {
        if (Objects.isNull(countryEntities)) return null;
        return countryEntities.stream().map(CountryMapping::entityToResponse).collect(Collectors.toList());
    }
}
