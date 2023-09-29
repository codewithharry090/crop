package com.test.crop.repository;

import com.test.crop.entity.ConfigurationEntity;
import com.test.crop.entity.CountryEntity;
import com.test.crop.entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, Long> {

    Optional<ConfigurationEntity> findByCountryEntityCountryCode(String countryCode);

    Optional<ConfigurationEntity> findByCropEntityCropCode(String cropCode);
}
