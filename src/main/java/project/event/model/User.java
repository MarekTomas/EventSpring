package project.event.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean active;
	@Email(message="{project.event.email}")
	@NotEmpty(message="{project.event.notEmpty}")
	private String email;
	@NotEmpty(message="{project.event.notEmpty}")
	private String name;
	@NotEmpty(message="{project.event.notEmpty}")
	private String surname;
	@Length(min=8, message="{project.event.password.length}")
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
	}
	public User(int id, boolean active, String email, String name, String surname, String password) {
		this.id = id;
		this.active = active;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", active=" + active + ", email=" + email + ", name=" + name + ", surname=" + surname
				+ ", password=" + password + "]";
	}
	
	
	
}
