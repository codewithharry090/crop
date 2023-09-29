package com.test.crop.service.impl;

import com.test.crop.dto.request.CropRequest;
import com.test.crop.dto.response.CropResponse;
import com.test.crop.entity.CropEntity;
import com.test.crop.mapper.CropMapping;
import com.test.crop.repository.CropRepository;
import com.test.crop.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CropServiceImpl implements CropService {

    @Autowired
    private CropRepository cropRepository;

    @Override
    public CropResponse createCrop(CropRequest cropRequest) {
        CropEntity parentCropEntity = null;
        if(!ObjectUtils.isEmpty(cropRequest.getParentCropCode())){
            parentCropEntity = cropRepository.findByCropCode(cropRequest.getParentCropCode()).orElseGet(null);
            if(Objects.isNull(parentCropEntity)){
                throw new EntityNotFoundException("parent crop is not found");
            }
        }
       
        CropEntity cropEntity = cropRepository.save(CropMapping.requestToEntity(cropRequest, parentCropEntity));
        return CropMapping.entityToResponse(cropEntity);
    }

    @Override
    public CropResponse getCropById(String cropCode) {
        CropEntity cropEntity = cropRepository.findByCropCode(cropCode).orElse(null);
        return CropMapping.entityToResponse(cropEntity);
    }

    @Override
    public List<CropResponse> getAllCrop() {
        List<CropEntity> cropEntities = cropRepository.findAll();
        return CropMapping.entityToResponseList(cropEntities);
    }

    @Override
    public CropResponse updateCrop(String cropCode, CropRequest cropRequest) {
        CropEntity cropEntity = cropRepository.findByCropCode(cropCode).orElse(null);
        if (cropEntity == null){
            throw new EntityNotFoundException("Entity Not found with crop code " + cropCode);
        }
        CropMapping.updateEntity(cropEntity, cropRequest);
        cropEntity = cropRepository.save(cropEntity);
        return CropMapping.entityToResponse(cropEntity);
    }
}
