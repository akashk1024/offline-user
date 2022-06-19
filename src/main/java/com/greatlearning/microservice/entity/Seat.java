package com.greatlearning.microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat implements Serializable {

    @Id
    private Integer seatnumber;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;

    private String seatname;
}
