package com.greatlearning.microservice.service;

import com.greatlearning.microservice.entity.Booking;
import com.greatlearning.microservice.entity.Seat;
import com.greatlearning.microservice.entity.Users;
import com.greatlearning.microservice.repository.BookingRepository;
import com.greatlearning.microservice.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Setter
public class BookTicketServiceImpl {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;

    public Booking bookSeats(String userName, Date date, Time time, int totalSeats) throws Exception {
        Optional<Users> users = userRepository.findById(userName);
        Booking booking = new Booking();
        booking.setUsers(Optional.of(users).orElseThrow(Exception::new).get());
        booking.setBookingDate(date);
        booking.setTotalBookedSeats(totalSeats);
        booking.setBookingTime(time);
        List<Seat> seatList = new ArrayList<>();
        booking.setSeat(seatList);

        Booking booking2 = bookingRepository.save(booking);
        for(int i = 0 ; i < totalSeats ; i++){
            seatList.add(Seat.builder().seatnumber(i+1).seatname("A" + i+1).build());
        }
        return booking2;
    }
}
