package com.test.crop.controller;

import com.test.crop.dto.request.CropRequest;
import com.test.crop.dto.response.CropResponse;
import com.test.crop.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/crop")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping
    public ResponseEntity<CropResponse> createCrop(@Valid @NotNull @RequestBody CropRequest cropRequest){
        return ResponseEntity.ok(cropService.createCrop(cropRequest));
    }

    @GetMapping("/{cropCode}")
    public ResponseEntity<CropResponse> getCropById( @Valid @NotNull @PathVariable("cropCode") String cropCode){
        return ResponseEntity.ok(cropService.getCropById(cropCode));
    }

    @GetMapping
    public ResponseEntity<List<CropResponse>> getAllCrop(){
        return ResponseEntity.ok(cropService.getAllCrop());
    }

    @PutMapping("/{cropCode}")
    public ResponseEntity<CropResponse> updateCrop(@Valid @NotNull @PathVariable("cropCode") String cropCode,
                                                    @RequestBody CropRequest cropRequest){
        return ResponseEntity.ok(cropService.updateCrop(cropCode, cropRequest));
    }

}
