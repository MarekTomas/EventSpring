package project.event.model;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String content;
	private Date term;
	private String timeStart;
	private String timeEnd;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Event(long id, String title, String content, Date term, String timeStart, String timeEnd) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.term = term;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	public Event() {
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", content=" + content + ", term=" + term + ", timeStart="
				+ timeStart + ", timeEnd=" + timeEnd + "]";
	}

	
}