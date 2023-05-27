package com.Stryker_Backend.Maven.entity.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="othertickets")
public class OtherTicketsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name="requested_date")
    private Date requestedDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "status")
    private String status;

    public OtherTicketsEntity() {
    }

    public OtherTicketsEntity(int id, String ticketNumber, Date requestedDate, Date returnDate, String status) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.requestedDate = requestedDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public OtherTicketsEntity(int i, String s) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
