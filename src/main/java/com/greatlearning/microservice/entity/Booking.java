package com.greatlearning.microservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_ID")
    @JsonProperty("bookingId")
    int bookingId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @JsonProperty("user")
    private Users users;

    @OneToMany(mappedBy = "booking")
    @JsonProperty("seat")
    private List<Seat> seat;

    @Column(name = "BOOKING_DaTE")
    @JsonProperty("bookingDate")
    private java.sql.Date bookingDate;

    @Column(name = "TOTAL_BOOKED_SEATS")
    @JsonProperty("totalSeats")
    private int totalBookedSeats;

    @Column(name = "BOOKING_TIME")
    @JsonProperty("bookingTime")
    private java.sql.Time bookingTime;

}
