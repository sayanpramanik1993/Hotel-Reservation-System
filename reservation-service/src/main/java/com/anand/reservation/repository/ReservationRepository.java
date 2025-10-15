package com.anand.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.reservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
