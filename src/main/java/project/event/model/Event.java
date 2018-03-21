package project.event.model;


import java.sql.Time;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private Date term;
	private Time tstart;
	private Time tend;
	public long getId() {
		return id;
	}
	public void setId(int id) {
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
	public Event(int id, String title, String content, Date term, Time tstart, Time tend) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.term = term;
		this.tstart = tstart;
		this.tend = tend;
	}
	public Event() {
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", content=" + content + ", term=" + term + ", tstart=" + tstart
				+ ", tend=" + tend + "]";
	}
	
	
	
	
}