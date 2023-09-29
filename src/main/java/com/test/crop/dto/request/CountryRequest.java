package com.test.crop.dto.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CountryRequest {
    @NotBlank(message = "countryCode cant be null or empty")
    private String countryCode;

    @NotBlank(message = "countryName cant be null or empty")
    private String countryName;
}
