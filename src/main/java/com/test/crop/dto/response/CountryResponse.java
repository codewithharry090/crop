package com.test.crop.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryResponse {

    private Long id;

    private String countryCode;

    private String countryName;
}
