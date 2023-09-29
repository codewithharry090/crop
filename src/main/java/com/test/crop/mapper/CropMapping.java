package com.test.crop.mapper;

import com.test.crop.dto.request.CountryRequest;
import com.test.crop.dto.request.CropRequest;
import com.test.crop.dto.response.CropResponse;
import com.test.crop.entity.CountryEntity;
import com.test.crop.entity.CropEntity;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CropMapping {
    public static CropEntity requestToEntity(CropRequest cropRequest, CropEntity parentCropEntity) {
        if (Objects.isNull(cropRequest)) return null;
        return CropEntity.builder()
                .cropCode(cropRequest.getCropCode())
                .cropName(cropRequest.getCropName())
                .taxonomyClassCode(cropRequest.getTaxonomyClassCode())
                .taxonomyClassName(cropRequest.getTaxonomyClassCode().name())
                .parentCropEntity(parentCropEntity)
                .build();
    }

    public static CropResponse entityToResponse(CropEntity cropEntity) {
        if (Objects.isNull(cropEntity)) return null;
        return CropResponse.builder()
                .id(cropEntity.getId())
                .cropCode(cropEntity.getCropCode())
                .cropName(cropEntity.getCropName())
                .taxonomyClassCode(cropEntity.getTaxonomyClassCode())
                .taxonomyClassName(cropEntity.getTaxonomyClassCode().name())
                .parentCropCode(cropEntity.getParentCropEntity() != null ? cropEntity.getParentCropEntity().getCropCode() : null)
                .parentCropName(cropEntity.getParentCropEntity() != null ? cropEntity.getParentCropEntity().getCropName() : null)
                .build();
    }

    public static CropEntity updateEntity(CropEntity cropEntity, CropRequest cropRequest) {
        if (Objects.isNull(cropEntity)) return cropEntity;
        if (Objects.isNull(cropRequest)) return cropEntity;

        if (!ObjectUtils.isEmpty(cropRequest.getCropCode())) {
            cropEntity.setCropCode(cropRequest.getCropCode());
        }
        if (!ObjectUtils.isEmpty(cropRequest.getCropName())) {
            cropEntity.setCropName(cropRequest.getCropName());
        }
        if (cropRequest.getTaxonomyClassCode() != null) {
            cropEntity.setTaxonomyClassCode(cropRequest.getTaxonomyClassCode());
            cropEntity.setTaxonomyClassName(cropRequest.getTaxonomyClassCode().name());
        }
//        if (!ObjectUtils.isEmpty(cropRequest.getParentCropCode())) {
//            cropEntity.setParentCropCode(cropRequest.getParentCropCode());
//        }
//        if (!ObjectUtils.isEmpty(cropRequest.getParentCropName())) {
//            cropEntity.setParentCropName(cropRequest.getParentCropName());
//        }
        return cropEntity;
    }

    public static List<CropResponse> entityToResponseList(List<CropEntity> cropEntities) {
        if (Objects.isNull(cropEntities)) return null;
        return cropEntities.stream().map(CropMapping::entityToResponse).collect(Collectors.toList());
    }
}
