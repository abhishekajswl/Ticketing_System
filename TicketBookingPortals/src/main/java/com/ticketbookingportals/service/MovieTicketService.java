package com.ticketbookingportals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbookingportals.entity.MovieTicket;
import com.ticketbookingportals.repository.MovieTicketRepository;

@Service
public class MovieTicketService {
	
	@Autowired
	private MovieTicketRepository mTicketRepository;
	
	public void addMovieTicket(MovieTicket mTicket) {
		mTicketRepository.save(mTicket);
	}
	
	public List<MovieTicket> getAllMovieTicket(){
		return mTicketRepository.findAll();
	}
	
	public MovieTicket getMovieTicketById(int movieTicketlId) {
		Optional<MovieTicket> movieTicket = mTicketRepository.findById(movieTicketlId);
		if(movieTicket.isEmpty()) {
			throw new RuntimeException("Unable to find Movie Ticket with Id : "+movieTicketlId);
		}
		
		return movieTicket.get();
	}
	
	public void deleteMovieTicketById(int id) {
		mTicketRepository.deleteById(id);
	}

}
