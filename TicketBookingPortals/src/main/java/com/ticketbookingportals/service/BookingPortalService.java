package com.ticketbookingportals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbookingportals.entity.BookingPortal;
import com.ticketbookingportals.repository.BookingPortalRepository;


@Service
public class BookingPortalService {
	
	@Autowired
	private BookingPortalRepository bPortalRepository;
	
	public BookingPortal getBookingPortalByName(String portalName) {
		return bPortalRepository.findAll().stream().filter((bPortal) -> bPortal.getPortlName().equalsIgnoreCase(portalName))
				.findFirst().get();
	}
	
	public boolean checkBookingPortalExistsOrNot(String portalName) {
		Optional<BookingPortal> bookingPortal = bPortalRepository.findAll().stream().filter((bPortal) -> bPortal.getPortlName().equalsIgnoreCase(portalName))
										.findFirst();
		if(bookingPortal.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public String addBookingPortal(BookingPortal bookingPortal) {
		bPortalRepository.save(bookingPortal);
		return "Booking Portal Added Successfully.";
	}
	
	public List<BookingPortal> getAllPortal(){
		return bPortalRepository.findAll();
	}
	
	public BookingPortal getPortalById(int bPortalId) {
		Optional<BookingPortal> bPortal = bPortalRepository.findById(bPortalId);
		if(bPortal.isEmpty()) {
			throw new RuntimeException("Unable to find Booking Portal with Id : "+bPortalId);
		}
		
		return bPortal.get();
	}
	
	public String deleteBookingPortalById(int id) {
		bPortalRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking Portal does not exist with Id : "+ id));
		bPortalRepository.deleteById(id);
		return "Booking Portal Deleted Successfully.";
	}
	
	public String updateBookingPortal(BookingPortal bPortal, int portalId) {
		BookingPortal bportal2 = bPortalRepository.findById(portalId).orElseThrow(() -> new RuntimeException("Booking Porta does not exist with id : " + portalId) );
		bPortal.setMovieTicket(bportal2.getMovieTicket());
		bPortalRepository.save(bPortal);
		return "Booking Portal Updated Successfully";
	}
	
	public List<BookingPortal> getAllBookingPortalOrderByTicketPriceInDesc(){
		return bPortalRepository.getAllBookingPortalOrderByTicketPriceInDesc();
	}

}
