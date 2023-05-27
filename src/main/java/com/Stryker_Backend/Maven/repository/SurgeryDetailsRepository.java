package com.Stryker_Backend.Maven.repository;

import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurgeryDetailsRepository extends JpaRepository<SurgeryDetailsEntity,Integer> {

    @Query(value = "SELECT * FROM `surgerydetails` WHERE `ticket_id`=:ticketId",nativeQuery = true)
    List<SurgeryDetailsEntity> FindbyTicketId(@Param("ticketId") String ticketId);

}

