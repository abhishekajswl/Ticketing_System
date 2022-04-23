package com.ticketbookingportals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbookingportals.entity.BookingPortal;
import com.ticketbookingportals.service.BookingPortalService;

@RestController
public class BookingPortalController {
	
	@Autowired
	private BookingPortalService bPortalService;
	
//	@PostMapping("/addbookingportal")
//	public ResponseEntity<String> createBookingPortal(@RequestBody BookingPortal bPortal ) {
//		
//		if(bPortalService.addBookingPortal(bPortal) == null) {
//			return new ResponseEntity<>("Failed to add Booking Portal!", HttpStatus.BAD_REQUEST);
//		};
//		
//		return new ResponseEntity<>("Successfully added the new Booking Portal!", HttpStatus.OK);
//		
//	}
	
	
	
//  //http://localhost:8080/addbookingportal	
//	    {
//		"portlName":"portal-3"
//		}
	@PostMapping("/addbookingportal")
	public ResponseEntity<String> createBookingPortal(@RequestBody BookingPortal bookingPortal ) {
		if(bPortalService.checkBookingPortalExistsOrNot(bookingPortal.getPortlName())) {
			return new ResponseEntity<>("Booking Portal already Exist with name : " + bookingPortal.getPortlName(), HttpStatus.BAD_REQUEST);
		}
		
		bPortalService.addBookingPortal(bookingPortal);	
		
		return new ResponseEntity<>("Successfully added new Booking Portal", HttpStatus.OK);
		
	}
	
	//http://localhost:8080/getallbookingportal
	@GetMapping("/getallbookingportal")
	public List<BookingPortal> getAllBooikingPortal() {
		return bPortalService.getAllPortal();
	}
	
	
	//http://localhost:8080/getbookingportalbyid/1
	@GetMapping("/getbookingportalbyid/{id}")
	public BookingPortal getBookingPortalById(@PathVariable int id) {
		return bPortalService.getPortalById(id);
	}
	
	//http://localhost:8080/updatebookingportal/3
//	{
//	 "portalId":3,
//	 "portlName":"portal-3"
//	 }
	@PutMapping("/updatebookingportal/{id}")
	public ResponseEntity<String> updateBookingPortal(@RequestBody BookingPortal bPortal,@PathVariable int id) {
		return new ResponseEntity<>(bPortalService.updateBookingPortal(bPortal, id), HttpStatus.OK);
	}
	
	//http://localhost:8080/deletebookingportal/1
	@DeleteMapping("/deletebookingportal/{id}")
	public ResponseEntity<String> deleteBookingPortalById(@PathVariable int id) {
		return new ResponseEntity<>(bPortalService.deleteBookingPortalById(id), HttpStatus.OK);
	}
	
	//http://localhost:8080/getallbookingportalorderbyticketpriceindesc
	@GetMapping("getallbookingportalorderbyticketpriceindesc")
	public List<BookingPortal> getAllBookingPortalOrderByTicketPriceInDesc(){
		return bPortalService.getAllBookingPortalOrderByTicketPriceInDesc();
	}
	

}
