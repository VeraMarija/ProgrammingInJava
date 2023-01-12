package com.example.app.Repository;

import com.example.app.Entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement,Long>{
    List<Measurement> findMeasurementByDevice_Id(Long id);

    List<Measurement> findByYyear(Integer year);

    List<Measurement> findByMmonthAndYyear(String month, Integer year);
}
