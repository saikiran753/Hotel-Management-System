package com.demoProject.demo.services;

import com.demoProject.demo.Models.HotelsModel;
import com.demoProject.demo.Repositary.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private HotelRepository hotelRepository;


    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    public HotelsModel addHotel(HotelsModel  newHotel){
        System.out.println(newHotel);

        return this.hotelRepository.save(newHotel);
    }


    public List<HotelsModel> getAll() {



        return hotelRepository.findAll();
    }

    public List<HotelsModel> getByLocation(String hotelLocation) {

        System.out.println(hotelLocation);
        return hotelRepository.findByhotelLocation(hotelLocation);
    }

//    public  List<HotelsModel> getByLocationAndDate( String fromDate, String toDate) throws ParseException {
//        System.out.println(fromDate);
//        System.out.println(toDate);
//
//        Date date1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(fromDate);
//        Date date2=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(toDate);
//
//
//        return  hotelRepository.findByAvailableDateBetween(date1, date2);
//    }

//    public List<HotelsModel> getByLocationAndDate(Date start, Date end) {
//
//        return  hotelRepository.findByAvailableDateBetween(start, end);
//    }
}
