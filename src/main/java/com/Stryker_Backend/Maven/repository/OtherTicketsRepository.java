package com.Stryker_Backend.Maven.repository;

import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherTicketsRepository extends JpaRepository<OtherTicketsEntity,Integer> {

    @Query(value = "SELECT * FROM `othertickets` WHERE `ticket_number`!=:ticketNumber",nativeQuery = true)
    List<OtherTicketsEntity> FindAllOtherTickets(@Param("ticketNumber") String ticketNumber);
}


