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
	
//	public BookingPortal addBookingPortal(BookingPortal bPortal) {
//		if (bPortalRepository.findByBookingPortalName(bPortal.getPortlName()).isPresent()) {
//			throw new RuntimeException("portal name already exist");
//		}
//		return bPortalRepository.save(bPortal);
//		
//	}
	
	public void addBookingPortal(BookingPortal bookingPortal) {
		bPortalRepository.save(bookingPortal);
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
	
	public void deleteBookingPortalById(int id) {
		bPortalRepository.deleteById(id);
	}

}
