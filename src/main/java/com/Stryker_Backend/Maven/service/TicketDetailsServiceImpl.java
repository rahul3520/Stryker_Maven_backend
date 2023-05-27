package com.Stryker_Backend.Maven.service;

import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import com.Stryker_Backend.Maven.repository.HospitalDetailsRepository;
import com.Stryker_Backend.Maven.repository.OtherTicketsRepository;
import com.Stryker_Backend.Maven.repository.SurgeryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TicketDetailsServiceImpl implements TicketDetailsService{

    @Autowired
    private SurgeryDetailsRepository sdrepo;

    @Autowired
    private OtherTicketsRepository otrepo;

    @Autowired
    private HospitalDetailsRepository hdrepo;


    @Override
    public List<HospitalDetailsEntity> GetHospitalDetails(String customer_name)
    {
        return hdrepo.FetchHospitalDetails(customer_name);
    }

    @Override
    public List<OtherTicketsEntity> GetAllOtherTickets(String ticketNumber)
    {
        return otrepo.FindAllOtherTickets(ticketNumber);
    };

    @Override
    public List<SurgeryDetailsEntity> GetSurgeryDetails()
    {
        return sdrepo.findAll();
    };

    @Override
    public Optional<SurgeryDetailsEntity> GetFirstSurgeryDetails(int row)
    {
        return sdrepo.findById(row);
    };

    @Override
    public List<SurgeryDetailsEntity> GetbyTicketId(String ticketId)
    {
        return sdrepo.FindbyTicketId(ticketId);
    };
}
