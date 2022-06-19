package com.greatlearning.microservice.controller;

import com.greatlearning.microservice.entity.Booking;
import com.greatlearning.microservice.service.BookTicketServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@RestController
@RequestMapping("/app")
public class BookingController {

    private BookTicketServiceImpl bookTicketService;

    BookingController(BookTicketServiceImpl bookTicketService){
        this.bookTicketService = bookTicketService;
    }

   @ApiModelProperty(
            value = "date value",
            name = "date",
            dataType = "Date",
            example = "YYYY-MM-dd")
    @PostMapping("/book")
    public ResponseEntity<Booking> bookSeats(@RequestParam String userName,
                                             @ApiParam(
                                                       name = "date",
                                                       type = "Date",
                                                       value = "Booking Date",
                                                       example = "yyyy-MM-dd",
                                                       required = true)
                                             //@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                             @RequestParam Date date,
                                             @RequestParam @DateTimeFormat(pattern = "HH:mm:ss") LocalTime time,
                                             @RequestParam int totalSeats) throws Exception {
        return new ResponseEntity(bookTicketService.bookSeats(userName, date,Time.valueOf(time),
                totalSeats), HttpStatus.CREATED);
    }
}
