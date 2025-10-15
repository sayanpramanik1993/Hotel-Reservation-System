package com.anand.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.hotelmanagement.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {}
