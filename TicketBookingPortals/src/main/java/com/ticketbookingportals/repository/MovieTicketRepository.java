package com.ticketbookingportals.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketbookingportals.entity.MovieTicket;

@Repository
public interface MovieTicketRepository extends JpaRepository<MovieTicket, Integer> {
	//Optional<MovieTicket> findByMovieNmae(String mname);
	
	//@Query("select m from MovieTicket mt") //JPQA : Java Persistence Query Language
	//List<MovieTicket> getAllMovieTicket();
	
}
