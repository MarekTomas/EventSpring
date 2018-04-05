package project.event.model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	
	@NotEmpty(message="{project.event.notEmpty}")
	private String title;
	
	@NotEmpty(message="{project.event.notEmpty}")
	private String content;
	
	@DateTimeFormat(iso=ISO.DATE)
	private Date term;
	
	private Time tstart;
	
	private Time tend;
	
	private String address;
	
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
	}

	public Time getTstart() {
		return tstart;
	}

	public void setTstart(Time tstart) {
		this.tstart = tstart;
	}

	public Time getTend() {
		return tend;
	}

	public void setTend(Time tend) {
		this.tend = tend;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", content=" + content + ", term=" + term + ", tstart=" + tstart
				+ ", tend=" + tend + ", address=" + address + ", price=" + price + "]";
	}

	public Event(Long id, String title, String content, Date term, Time tstart, Time tend, String address, int price) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.term = term;
		this.tstart = tstart;
		this.tend = tend;
		this.address = address;
		this.price = price;
	}

	public Event() {
	} 
	
	
}