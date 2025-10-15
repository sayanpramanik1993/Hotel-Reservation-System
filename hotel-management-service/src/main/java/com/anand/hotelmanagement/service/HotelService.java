package com.anand.hotelmanagement.service;

import com.anand.hotelmanagement.entity.Hotel;
import com.anand.hotelmanagement.entity.Room;
import com.anand.hotelmanagement.repository.HotelRepository;
import com.anand.hotelmanagement.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAvailableRooms(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).get();
        return hotel.getRooms().stream().filter(r->"AVAILABLE".equalsIgnoreCase(r.getRoomStatus())).toList();
    }

    public Room updateRoom(Long id, Long roomNumber, String roomStatus) {
        Room room = roomRepository.findByHotelIdAndRoomNumber(id, roomNumber);
        room.setRoomStatus(roomStatus);
        return roomRepository.save(room);

    }

    public Room getRoom(Long id, Long roomNumber) {
        return roomRepository.findByHotelIdAndRoomNumber(id, roomNumber);
    }

    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id).get();
    }
}
