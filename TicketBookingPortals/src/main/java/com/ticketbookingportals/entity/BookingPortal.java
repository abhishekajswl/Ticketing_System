package com.ticketbookingportals.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "booking_portal")
public class BookingPortal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "portal_id")
	private int portalId;
	
	@Column(name = "portal_name", nullable = false)
	private String portlName;
	
	
	@OneToMany(mappedBy = "bookingPortal", cascade = CascadeType.PERSIST)
	List<MovieTicket> movieTicket;
	
	
	
	
	public BookingPortal() {
		super();
	}

	public BookingPortal(int portalId, String portlName, List<MovieTicket> movieTicket) {
		super();
		this.portalId = portalId;
		this.portlName = portlName;
		this.movieTicket = movieTicket;
	}
	
	public BookingPortal(String portlName, List<MovieTicket> movieTicket) {
		super();
		this.portlName = portlName;
		this.movieTicket = movieTicket;
	}

	public int getPortalId() {
		return portalId;
	}
	public String getPortlName() {
		return portlName;
	}

	public List<MovieTicket> getMovieTicket() {
		return movieTicket;
	}

	public void setMovieTicket(List<MovieTicket> movieTicket) {
		this.movieTicket = movieTicket;
	}

	public void setPortalId(int portalId) {
		this.portalId = portalId;
	}

	public void setPortlName(String portlName) {
		this.portlName = portlName;
	}
	

}
