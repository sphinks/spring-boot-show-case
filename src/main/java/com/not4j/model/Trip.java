package com.not4j.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: ivan
 * Date: 28.05.16
 * Time: 22:12
 */
@Entity
public class Trip {

    @Id
    @GeneratedValue
    private Long tripId;
    private String destination;
    private Date start;
    private Date end;
    @ManyToOne
    @JsonIgnore
    private User user;

    public Trip() {
    }

    public Trip(User user, String destination, Date start, Date end) {
        this.user = user;
        this.destination = destination;
        this.start = start;
        this.end = end;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
