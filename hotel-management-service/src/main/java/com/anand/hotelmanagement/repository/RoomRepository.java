package com.anand.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.hotelmanagement.entity.Hotel;
import com.anand.hotelmanagement.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByHotelIdAndRoomNumber(Long id, Long roomNumber);
}
