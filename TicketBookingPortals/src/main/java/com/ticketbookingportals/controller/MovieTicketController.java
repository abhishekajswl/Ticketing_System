package com.ticketbookingportals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbookingportals.entity.MovieTicket;
import com.ticketbookingportals.service.MovieTicketService;

@RestController
public class MovieTicketController {
	
	@Autowired
	private MovieTicketService mTicketService;
	
//  //http://localhost:8080/addmovieticket	
//	   {
//		"movieName":"movie-4",
//		"ticketPrice":123,
//		"bookingPortal":1
//		}
	@PostMapping("/addmovieticket")
	public void addMovieTicket(@RequestBody MovieTicket movieTicket) {
		mTicketService.addMovieTicket(movieTicket);

	}

    //http://localhost:8080/getallmovieticket
	@GetMapping("/getallmovieticket")
	public List<MovieTicket> getAllMovieTicket() {
		return mTicketService.getAllMovieTicket();
	}

    //http://localhost:8080/getmovieticketbyid/1
	@GetMapping("/getmovieticketbyid/{id}")
	public MovieTicket getMovieTicketById(@PathVariable int id) {
		return mTicketService.getMovieTicketById(id);
	}

	//http://localhost:8080/updatemovieticket/4
//	    {
//		"movieTicketId": 4,
//		"movieName":"movie-4",
//		"ticketPrice":450,
//		"bookingPortal":2
//		}
	@PutMapping("/updatemovieticket/{id}")
	public void updateMovieTicket(@RequestBody MovieTicket mTicket, @PathVariable int id) {
		MovieTicket mTicket2 = mTicketService.getMovieTicketById(id);
		mTicket2.setBookingPortal(mTicket.getBookingPortal());
		mTicket2.setMovieName(mTicket.getMovieName());
		mTicket2.setTicketPrice(mTicket.getTicketPrice());
		mTicketService.addMovieTicket(mTicket2);
	}

    //http://localhost:8080/deletemovieticket/4
	@DeleteMapping("deletemovieticket/{id}")
	public void deleteMovieTicketById(@PathVariable int id) {
		mTicketService.deleteMovieTicketById(id);
	}	
	

}
