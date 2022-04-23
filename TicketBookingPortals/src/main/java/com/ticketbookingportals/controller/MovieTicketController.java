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
	public ResponseEntity<String> addMovieTicket(@RequestBody MovieTicket movieTicket) {
		if(mTicketService.checkMovieTicketExistsOrNot(movieTicket.getMovieName())) {
			return new ResponseEntity<>("Movie Ticket already exist with name : " + movieTicket.getMovieName(), HttpStatus.BAD_REQUEST);
		} else {
			mTicketService.addMovieTicket(movieTicket);
			return new ResponseEntity<>("Successfully added the new movie Ticket", HttpStatus.OK);
		}

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
	public ResponseEntity<String> updateMovieTicket(@RequestBody MovieTicket mTicket, @PathVariable int id) {
		return new ResponseEntity<>(mTicketService.updateMovieTicket(mTicket, id), HttpStatus.OK);
	}

    //http://localhost:8080/deletemovieticket/4
	@DeleteMapping("/deletemovieticket/{id}")
	public ResponseEntity<String> deleteMovieTicketById(@PathVariable int id) {
		return new ResponseEntity<>(mTicketService.deleteMovieTicketById(id), HttpStatus.OK);
	}	
	

}
