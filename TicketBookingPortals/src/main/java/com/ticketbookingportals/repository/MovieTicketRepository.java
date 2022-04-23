package com.ticketbookingportals.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketbookingportals.entity.MovieTicket;

@Repository
public interface MovieTicketRepository extends JpaRepository<MovieTicket, Integer> {
	Optional<MovieTicket> findByMovieName(String name);
	
	@Query("select m from MovieTicket m") //JPQL : Java Persistence Query Language // both the 'm' should be same in JPQL
	List<MovieTicket> getAllMovieTicket();
	
}
