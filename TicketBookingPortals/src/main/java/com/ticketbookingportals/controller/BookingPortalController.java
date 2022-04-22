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
	public void createBookingPortal(@RequestBody BookingPortal bookingPortal ) {
		bPortalService.addBookingPortal(bookingPortal);	
		
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
	public void updateBookingPortal(@RequestBody BookingPortal bPortal,@PathVariable int id) {
		BookingPortal bPortal2 = bPortalService.getPortalById(id);
		bPortal2.setMovieTicket(bPortal.getMovieTicket());
		bPortal2.setPortlName(bPortal.getPortlName());
		bPortalService.addBookingPortal(bPortal2);
	}
	
	//http://localhost:8080/deletebookingportal/1
	@DeleteMapping("deletebookingportal/{id}")
	public void deleteBookingPortalById(@PathVariable int id) {
		bPortalService.deleteBookingPortalById(id);
	}
	

}
