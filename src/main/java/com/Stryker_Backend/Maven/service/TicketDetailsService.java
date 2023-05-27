package com.Stryker_Backend.Maven.service;

import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public interface TicketDetailsService {

    public List<SurgeryDetailsEntity> GetSurgeryDetails();

    public Optional<SurgeryDetailsEntity> GetFirstSurgeryDetails(int row);
    public List<HospitalDetailsEntity> GetHospitalDetails(String customer_name);

    public List<OtherTicketsEntity> GetAllOtherTickets(String ticketNumber);

    public List<SurgeryDetailsEntity> GetbyTicketId(String ticketId);


}

