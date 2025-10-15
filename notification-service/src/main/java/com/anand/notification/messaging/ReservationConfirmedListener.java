package com.anand.notification.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.anand.notification.model.Customer;
import com.anand.notification.model.ReservationNotification;

@Component
@Slf4j
public class ReservationConfirmedListener {
    @Autowired
    JavaMailSender javaMailSender;

    @KafkaListener(topics = "ConfirmReservation", groupId = "myGroup", containerFactory = "reservationNotificationKafkaListenerContainerFactory")
    public void sendEmail(ReservationNotification reservationNotification) {
        log.info("Received Message in group myGroup: " + reservationNotification);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@amhotels.com");
        message.setTo(reservationNotification.getEmail());
        message.setSubject("Reservation Confirmed");
        message.setText(String.format("Dear %s Your booking for hotel %s is confirmed from %s to %s",
                reservationNotification.getCustomerName(),
                reservationNotification.getHotelName(), reservationNotification.getStartDate(), reservationNotification.getEndDate()));
        javaMailSender.send(message);
    }
}
