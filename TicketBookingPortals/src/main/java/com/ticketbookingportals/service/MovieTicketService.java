package com.ticketbookingportals.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbookingportals.entity.MovieTicket;
import com.ticketbookingportals.repository.MovieTicketRepository;

@Service
public class MovieTicketService {
	
	@Autowired
	private MovieTicketRepository mTicketRepository;
	
	public boolean checkMovieTicketExistsOrNot(String movieName) {
		Optional<MovieTicket> mTicket = mTicketRepository.findByMovieName(movieName);
		if(mTicket.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public MovieTicket getMovieByName(String name) {
		Optional<MovieTicket> mTicket = mTicketRepository.findByMovieName(name);
		if(mTicket.isEmpty()) {
			throw new RuntimeException("Movie Ticket doesn't exist with name : " +name);
		}
		return mTicket.get();
	}
	
	public String addMovieTicket(MovieTicket mTicket) {
		mTicketRepository.save(mTicket);
		return "Movie Added Successfully";
	}
	
	public List<MovieTicket> getAllMovieTicket(){
		return mTicketRepository.findAll().stream().collect(Collectors.toList());
		// return mTicketRepository.getAllMovieTicket();
	}
	
	public MovieTicket getMovieTicketById(int movieTicketlId) {
		Optional<MovieTicket> movieTicket = mTicketRepository.findById(movieTicketlId);
		if(movieTicket.isEmpty()) {
			throw new RuntimeException("Unable to find Movie Ticket with Id : "+movieTicketlId);
		}
		
		return movieTicket.get();
	}
	
	public String updateMovieTicket(MovieTicket mTicket, int movieId) {
		MovieTicket mTicket2 = mTicketRepository.findById(movieId)
									.orElseThrow(() -> new RuntimeException("Movie does not exist with id : " + movieId));
		mTicket.setBookingPortal(mTicket2.getBookingPortal());
		mTicketRepository.save(mTicket);
		return "Movie updated Successfully";
	}
	
	public String deleteMovieTicketById(int id) {
		mTicketRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie Ticket doesn't exist with id : " + id));
		mTicketRepository.deleteById(id);
		return "Movie Deleted Successfully";
	}

}
