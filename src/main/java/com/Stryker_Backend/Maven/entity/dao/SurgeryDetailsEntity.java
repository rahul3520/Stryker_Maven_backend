package com.Stryker_Backend.Maven.entity.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="surgerydetails")
public class SurgeryDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name="surgery_name")
    private String surgeryName;

    @Column(name = "duration")
    private String duration;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date date;

    @Column(name="items_ordered")
    private int itemsOrdered;

    @Column(name="priority")
    private String priority;

    @Column(name="status")
    private String status;

    @Column(name="assigned_agent")
    private String assignedAgent;

    @Column(name="doctor_list")
    private String doctorList;

    @Column(name="hospital_name")
    private String hospitalName;

    public SurgeryDetailsEntity() {
    }

    public SurgeryDetailsEntity(int id, String ticketId, String surgeryName, String duration, Date date, int itemsOrdered, String priority, String status, String assignedAgent, String doctorList, String hospitalName) {
        this.id = id;
        this.ticketId = ticketId;
        this.surgeryName = surgeryName;
        this.duration = duration;
        this.date = date;
        this.itemsOrdered = itemsOrdered;
        this.priority = priority;
        this.status = status;
        this.assignedAgent = assignedAgent;
        this.doctorList = doctorList;
        this.hospitalName = hospitalName;
    }

    public SurgeryDetailsEntity(int i, String s) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(int itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(String assignedAgent) {
        this.assignedAgent = assignedAgent;
    }

    public String getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(String doctorList) {
        this.doctorList = doctorList;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}

