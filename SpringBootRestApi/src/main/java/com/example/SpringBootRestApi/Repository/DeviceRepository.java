package com.example.SpringBootRestApi.Repository;

import com.example.SpringBootRestApi.Models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
}
