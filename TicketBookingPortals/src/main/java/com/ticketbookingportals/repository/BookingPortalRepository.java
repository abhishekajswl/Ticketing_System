package com.ticketbookingportals.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbookingportals.entity.BookingPortal;

@Repository
public interface BookingPortalRepository extends JpaRepository<BookingPortal, Integer> {
	//Optional<BookingPortal> findByBookingPortalName(String name);

}
