package com.test.crop.repository;

import com.test.crop.entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CropRepository extends JpaRepository<CropEntity, Long> {

    Optional<CropEntity> findByCropCode(String cropCode);
}
