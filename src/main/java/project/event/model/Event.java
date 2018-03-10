package project.event.model;

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
	private String startDate;
	private String startTime;
	private String endTime;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Event() {
	}
	public Event(long id, String title, String content, String startDate, String startTime, String endTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", content=" + content + ", startDate=" + startDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
