package com.demoProject.demo.Repositary;

import com.demoProject.demo.Models.HotelsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface HotelRepository extends JpaRepository<HotelsModel, Long> {



    List<HotelsModel> findByhotelLocation(String hotelLocation);
    List<HotelsModel> findByAvailableDateBetween(Date startDate, Date endDate);
    List<HotelsModel> findByHotelLocationAndAvailableDateBetween(String hotelLocation,Date startDate, Date endDate);
}
