package com.wwsis.noclegi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepo extends JpaRepository <Hotel, Integer> {

    List<Hotel> findAllBynazwa(String wyszukaj);
}
