package com.demoProject.demo.Repositary;

import com.demoProject.demo.Models.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingModel,Long> {
}
