package com.demoProject.demo.services;

import com.demoProject.demo.Classes.*;
import com.demoProject.demo.Models.BookingModel;
import com.demoProject.demo.Models.UserRegistrationModel;
import com.demoProject.demo.Repositary.BookingRepository;
import com.demoProject.demo.Repositary.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private BookingRepository bookingRepository;

    private UserRegistrationRepo userRegistrationRepo;


    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRegistrationRepo userRegistrationRepo) {
        this.bookingRepository = bookingRepository;
        this.userRegistrationRepo = userRegistrationRepo;
    }


    public BookingModel bookHotel( BookingDetail bookHotel,  String usernName){

        System.out.println(bookHotel.getBhk());
        System.out.println(bookHotel.getFoodPlan());
        System.out.println(bookHotel.getRoomType());

        Optional<UserRegistrationModel> userDetailResponse = this.userRegistrationRepo.findByuserName(usernName);

        UserRegistrationModel userd = userDetailResponse.get();
        System.out.println(userd.getFirstName());
        BookingModel bookingDetails = new BookingModel();
        bookingDetails.setUsername(userd.getUserName());
        bookingDetails.setCustomerName(userd.getFirstName() + userd.getLastName());
        bookingDetails.setCustomerPhoneNumber(userd.getPhoneNumber());
        String roomType = bookHotel.getRoomType();
        if(roomType.equals("DeluxAc")){
            DeluxAc deluxAc = new DeluxAc();
        MyHotelRoom myHotelRoom = new MyHotelRoom(deluxAc);
        System.out.println(myHotelRoom);
            myHotelRoom.bookMyRoom(bookHotel.getBhk(),bookHotel.getFoodPlan());
            Room room = myHotelRoom.getRoom();
        System.out.println("Builder constructed: "+ room.getFoodPlan());
        System.out.println("Builder constructed: "+ room.getView());
        System.out.println("Builder constructed: "+ room.getTelevision());
        System.out.println("Builder constructed: "+ room.getBHK());
            bookingDetails.setTelevison(room.getTelevision());
            bookingDetails.setBhk(room.getBHK());
            bookingDetails.setView(room.getView());
            bookingDetails.setFood(room.getFoodPlan());
            bookingDetails.setHotelName(bookHotel.getHotelName());
            bookingDetails.setRoomType(roomType);
            System.out.println(userd.getEmail());
            kafkaTemplate.send("test-topic4","maharaja.engg444@gmail.com");
            return this.bookingRepository.save(bookingDetails);
        }
        if(roomType.equals("DeluxNonAc")){
            DeluxNonAc deluxNonAc = new DeluxNonAc();
            MyHotelRoom myHotelRoom = new MyHotelRoom(deluxNonAc);
            System.out.println(myHotelRoom);
            myHotelRoom.bookMyRoom(bookHotel.getBhk(),bookHotel.getFoodPlan());
            Room room = myHotelRoom.getRoom();
            System.out.println("Builder constructed: "+ room.getFoodPlan());
            System.out.println("Builder constructed: "+ room.getView());
            System.out.println("Builder constructed: "+ room.getTelevision());
            System.out.println("Builder constructed: "+ room.getBHK());
            bookingDetails.setTelevison(room.getTelevision());
            bookingDetails.setBhk(room.getBHK());
            bookingDetails.setView(room.getView());
            bookingDetails.setFood(room.getFoodPlan());
            bookingDetails.setHotelName(bookHotel.getHotelName());
            bookingDetails.setRoomType(roomType);
            System.out.println(userd.getEmail());
            kafkaTemplate.send("test-topic4",userd.getEmail());
            return this.bookingRepository.save(bookingDetails);
        }
        if(roomType.equals("SuiteAc")){
            SuiteAc suiteAc = new SuiteAc();
            MyHotelRoom myHotelRoom = new MyHotelRoom(suiteAc);
            System.out.println(myHotelRoom);
            myHotelRoom.bookMyRoom(bookHotel.getBhk(),bookHotel.getFoodPlan());
            Room room = myHotelRoom.getRoom();
            System.out.println("Builder constructed: "+ room.getFoodPlan());
            System.out.println("Builder constructed: "+ room.getView());
            System.out.println("Builder constructed: "+ room.getTelevision());
            System.out.println("Builder constructed: "+ room.getBHK());
            bookingDetails.setTelevison(room.getTelevision());
            bookingDetails.setBhk(room.getBHK());
            bookingDetails.setView(room.getView());
            bookingDetails.setFood(room.getFoodPlan());
            bookingDetails.setHotelName(bookHotel.getHotelName());
            bookingDetails.setRoomType(roomType);
            kafkaTemplate.send("test-topic4",userd.getEmail());
            return this.bookingRepository.save(bookingDetails);
        } if(roomType.equals("SuiteNonAc")){
            SuiteNonAc suiteNonAc = new SuiteNonAc();
            MyHotelRoom myHotelRoom = new MyHotelRoom(suiteNonAc);
            System.out.println(myHotelRoom);
            myHotelRoom.bookMyRoom(bookHotel.getBhk(),bookHotel.getFoodPlan());
            Room room = myHotelRoom.getRoom();
            System.out.println("Builder constructed: "+ room.getFoodPlan());
            System.out.println("Builder constructed: "+ room.getView());
            System.out.println("Builder constructed: "+ room.getTelevision());
            System.out.println("Builder constructed: "+ room.getBHK());
            bookingDetails.setTelevison(room.getTelevision());
            bookingDetails.setBhk(room.getBHK());
            bookingDetails.setView(room.getView());
            bookingDetails.setFood(room.getFoodPlan());
            bookingDetails.setHotelName(bookHotel.getHotelName());
            bookingDetails.setRoomType(roomType);
            kafkaTemplate.send("test-topic4",userd.getEmail());
            return this.bookingRepository.save(bookingDetails);
        }
       return null;
    }

    public Double checkPriceOfHotel(BookingDetail bookHotel) {

        RoomBook roombook =bookHotel.getRoomType().startsWith("Delux")? new DeluxeRoom(): new SuiteRoom();
        RoomBook roombook2 = bookHotel.getBhk().equals("1")?new Onebhk(roombook):new Twobhk(roombook);
        RoomBook roombook3 = bookHotel.getRoomType().endsWith("NonAc")? new Nonac():new Ac(roombook2);
        RoomBook roombook4 = new Food(roombook3);
        PrintStream var10000 = System.out;
        String var10001 = roombook4.getDescription();
        var10000.println( var10001 + "$" + " is " + roombook4.cost());
        return roombook4.cost();
    }


}
