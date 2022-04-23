package com.ticketbookingportals.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketbookingportals.entity.BookingPortal;

@Repository
public interface BookingPortalRepository extends JpaRepository<BookingPortal, Integer> {
	//Optional<BookingPortal> findByBookingPortalName(String name);
	
	@Query("select b from BookingPortal b")   //JPQL
	List<BookingPortal> getAllBookingPortals();
	
	@Query("select b from BookingPortal b join b.movieTicket m order by m.ticketPrice desc")
	List<BookingPortal> getAllBookingPortalOrderByTicketPriceInDesc();

}
