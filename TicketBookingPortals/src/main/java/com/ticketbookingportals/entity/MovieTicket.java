package com.ticketbookingportals.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movie_ticket")
public class MovieTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_ticket_id", nullable = false)
	private int movieTicketId;
	
	@Column(name = "movie_name", nullable = false)
	private String movieName;
	
	@Column(name = "ticket_price", nullable = false)
	private int ticketPrice;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private BookingPortal bookingPortal;
	
	
	
	public MovieTicket() {
		super();
	}

	public MovieTicket(int movieTicketId, String movieName, int ticketPrice, BookingPortal bookingPortal) {
		super();
		this.movieTicketId = movieTicketId;
		this.movieName = movieName;
		this.ticketPrice = ticketPrice;
		this.bookingPortal = bookingPortal;
	}
	
	public MovieTicket(String movieName, int ticketPrice, BookingPortal bookingPortal) {
		super();
		this.movieName = movieName;
		this.ticketPrice = ticketPrice;
		this.bookingPortal = bookingPortal;
	}
	
	public BookingPortal getBookingPortal() {
		return bookingPortal;
	}

	public void setBookingPortal(BookingPortal bookingPortal) {
		this.bookingPortal = bookingPortal;
	}

	public void setMovieTicketId(int movieTicketId) {
		this.movieTicketId = movieTicketId;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getMovieTicketId() {
		return movieTicketId;
	}
	public String getMovieName() {
		return movieName;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	
	
	

}
