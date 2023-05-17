package com.demoProject.demo.Controller;


import com.demoProject.demo.Models.HotelsModel;
import com.demoProject.demo.Repositary.HotelRepository;
import com.demoProject.demo.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account/hotel")
public class HotelController {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public final HotelService hotelService;
    public final HotelRepository hotelRepository;



    public HotelController(HotelService hotelService, HotelRepository hotelRepository) {
        this.hotelService = hotelService;
        this.hotelRepository = hotelRepository;
    }


    @GetMapping("/all")
    public List<HotelsModel> getAllHotels(){
        return hotelService.getAll();

    }

//    @GetMapping(value="location")
//    @ResponseBody
//    public List<HotelsModel> getHotelsByLocation(@RequestParam("data") String hotelLocation){
//        System.out.println(hotelLocation);
//        return  hotelService.getByLocation(hotelLocation);
//
//    }

//    @GetMapping(value="location")
//    @ResponseBody
//    public List<HotelsModel> getHotelsByLocationAndDate(@RequestBody  Map<String,String> hotelLocationAndDate){
//        System.out.println(hotelLocationAndDate.get("location"));
//        return  this.hotelService.getByLocationAndDate(hotelLocationAndDate.get("location"),hotelLocationAndDate.get("fromDate"),hotelLocationAndDate.get("toDate"));
//
//    }

//    @GetMapping(value="location")
//    public ResponseEntity<List<HotelsModel>> getLaptopsByCreatedDate (@RequestBody  Map<String,String> hotelLocationAndDate) throws ParseException {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
//        Date fdate = formatter.parse(hotelLocationAndDate.get("fromDate"));
//        Date tdate = formatter.parse(hotelLocationAndDate.get("toDate"));
//        System.out.println(fdate);
//        System.out.println(formatter.format(fdate));
//      //  SimpleDateFormat  fd =new SimpleDateFormat("dd-mm-yyyy").parse(hotelLocationAndDate.get("fromDate"));
//        Date td =new SimpleDateFormat("dd-mm-yyyy").parse(hotelLocationAndDate.get("toDate"));
//
//       //System.out.println(fd);
//
//        return new ResponseEntity<List<HotelsModel>>(this.hotelService.getByLocationAndDate(formatter.format(fdate),
//                formatter.format(tdate)), HttpStatus.OK);
//
//
//    }


    @GetMapping(value="location/date")
    public ResponseEntity<List<HotelsModel>> getLaptopsByCreatedDate (@RequestBody Map<String,String> location, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @DateTimeFormat(pattern = "yyyy-MM-dd") Date end)  {
           System.out.println(location.get("location"));
        return new ResponseEntity<List<HotelsModel>> (this.hotelRepository.findByAvailableDateBetween(start,end), HttpStatus.OK);

    }
    @GetMapping(value="location/datee")
    public ResponseEntity<List<HotelsModel>> gethotelByLocationAndDate (@RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @DateTimeFormat(pattern = "yyyy-MM-dd") Date end, String location)  {

        return new ResponseEntity<List<HotelsModel>> (this.hotelRepository.findByHotelLocationAndAvailableDateBetween(location, start,end), HttpStatus.OK);

    }


    @PostMapping
    public HotelsModel addNewHotel(@RequestBody HotelsModel hotelsModel){
        System.out.println(hotelsModel);

        return hotelService.addHotel(hotelsModel);

    }





}
