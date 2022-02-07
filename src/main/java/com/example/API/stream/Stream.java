package com.example.API.stream;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Stream {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String iss, status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> aud, delivery, events_supported, events_requested, events_delivered;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Subject> subjects;

    public Stream() {}

    public Stream(String status) {
        this.status = status;
    }

    public Stream(String iss, List<String> aud, List<String> delivery) {
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
    }

    public Stream(String iss, String status, List<String> aud, List<String> delivery, List<String> events_supported, List<String> events_requested, List<String> events_delivered, List<Subject> subjects) {
        this.iss = iss;
        this.status = status;
        this.aud = aud;
        this.delivery = delivery;
        this.events_supported = events_supported;
        this.events_requested = events_requested;
        this.events_delivered = events_delivered;
        this.subjects = subjects;
    }

    public Stream(String iss, List<String> aud, List<String> delivery, List<String> events_supported, List<String> events_requested, List<String> events_delivered) {
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
        this.events_supported = events_supported;
        this.events_requested = events_requested;
        this.events_delivered = events_delivered;
    }

    public Stream(String iss, List<String> aud, List<String> delivery, List<String> events_requested) {
        this.iss = iss;
        this.aud = aud;
        this.delivery = delivery;
        this.events_requested = events_requested;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAud() {
        return aud;
    }

    public void setAud(List<String> aud) {
        this.aud = aud;
    }

    public List<String> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<String> delivery) {
        this.delivery = delivery;
    }

    public List<String> getEvents_supported() {
        return events_supported;
    }

    public void setEvents_supported(List<String> events_supported) {
        this.events_supported = events_supported;
    }

    public List<String> getEvents_requested() {
        return events_requested;
    }

    public void setEvents_requested(List<String> events_requested) {
        this.events_requested = events_requested;
    }

    public List<String> getEvents_delivered() {
        return events_delivered;
    }

    public void setEvents_delivered(List<String> events_delivered) {
        this.events_delivered = events_delivered;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
