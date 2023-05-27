package com.Stryker_Backend.Maven.repository;

import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalDetailsRepository extends JpaRepository<HospitalDetailsEntity,Integer> {

    @Query(value = "SELECT * FROM `hospitaldetails` WHERE `customer_name`=:customer_name",nativeQuery = true)
    List<HospitalDetailsEntity> FetchHospitalDetails(@Param("customer_name") String customer_name);
}

