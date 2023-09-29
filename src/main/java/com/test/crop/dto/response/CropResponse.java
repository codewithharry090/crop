package com.test.crop.dto.response;


import com.test.crop.enums.TaxonomyClass;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CropResponse {

    private Long id;

    private String cropCode;

    private String cropName;

    private TaxonomyClass taxonomyClassCode;

    private String taxonomyClassName;

    private String parentCropCode;

    private String parentCropName;
}
