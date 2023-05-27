package com.Stryker_Backend.Maven.controller;

import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import com.Stryker_Backend.Maven.service.TicketDetailsService;
import com.Stryker_Backend.Maven.service.TicketDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
public class TicketDetailsController {

    @Autowired
    private TicketDetailsService sdao;


    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllSurgeryDetails")
    public List<SurgeryDetailsEntity> ViewSurgeryDetails()
    {
        return sdao.GetSurgeryDetails();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewFirstRowOfSurgeryDetails")
    public Optional<SurgeryDetailsEntity> LoadFirstSurgeryDetails()
    {
        return sdao.GetFirstSurgeryDetails(1);
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewTicketDetails",produces = "application/json",consumes = "application/json")
    public List<SurgeryDetailsEntity> FindSurgeryDetails(@RequestBody SurgeryDetailsEntity s)
    {
        System.out.println(s.getTicketId());

        return sdao.GetbyTicketId(s.getTicketId());
    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/viewHospitalDetails")
//    public List<HospitalDetailsModel> FindHospitalDetails(@RequestParam(name = "currentHospital") String currentHospital)
//    {
////        System.out.println(h.getCustomerName());
//
////        return hdao.FetchHospitalDetails(h.getCustomerName());
//
//        return hdao.FetchHospitalDetails(currentHospital);
//    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewHospitalDetails/{currentHospital}")
    public List<HospitalDetailsEntity> FindHospitalDetails(@PathVariable String currentHospital)
    {
//        System.out.println(h.getCustomerName());

//        return hdao.FetchHospitalDetails(h.getCustomerName());

        return sdao.GetHospitalDetails(currentHospital);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewOtherTickets")
    public List<OtherTicketsEntity> FindOtherTickets(@RequestParam String ticketId)
    {
//        System.out.println(o.getTicketNumber());
//
//        return odao.FindAllOtherTickets(o.getTicketNumber());

        return  sdao.GetAllOtherTickets(ticketId);
    }


}
