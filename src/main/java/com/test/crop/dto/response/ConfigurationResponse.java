package com.test.crop.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfigurationResponse {

    private Long id;

    private String countryCode;

    private String cropCode;
}
