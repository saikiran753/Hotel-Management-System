package com.demoProject.demo.Controller;

import com.demoProject.demo.Classes.BookingDetail;
import com.demoProject.demo.Models.BookingModel;
import com.demoProject.demo.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class BookingController {

    public final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping(value="/{userName}")
    public BookingModel bookHotel(@RequestBody  BookingDetail bookHotel, @PathVariable("userName") String userName) {
        System.out.println(bookHotel);
        System.out.println(userName);
        //  ObjectMapper mapper=new ObjectMapper();

        // BookingDetail b = mapper.readValue(bookHotel,BookingDetail.class);


        return bookingService.bookHotel(bookHotel,userName);

    }
    @PostMapping(value="/check/{userName}")
    public Double checkPrice(@RequestBody  BookingDetail bookHotel,@PathVariable("userName") String userName){
        return bookingService.checkPriceOfHotel(bookHotel);
    }
}
