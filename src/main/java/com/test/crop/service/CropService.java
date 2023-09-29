package com.test.crop.service;

import com.test.crop.dto.request.CropRequest;
import com.test.crop.dto.response.CropResponse;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CropService {

    CropResponse createCrop(CropRequest cropRequest);

    CropResponse getCropById(String cropCode);

    List<CropResponse> getAllCrop();

    CropResponse updateCrop(@NotNull String cropCode, CropRequest cropRequest);
}
