package com.test.crop.dto.request;


import com.test.crop.enums.TaxonomyClass;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CropRequest {

    @NotBlank(message = "cropCode cant be null or empty")
    private String cropCode;

    @NotBlank(message = "cropName cant be null or empty")
    private String cropName;

    @NotNull(message = "taxonomyClassCode cant be null")
    private TaxonomyClass taxonomyClassCode;

    private String parentCropCode;

}
