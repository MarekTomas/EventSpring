package project.event.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Email(message="{project.event.email}")
	@NotEmpty(message="{project.event.notEmpty}")
	private String email;
	
	@NotEmpty(message="{project.event.notEmpty}")
	private String name;
	
	@NotEmpty(message="{project.event.notEmpty}")
	private String surname;
	
	@Length(min=8, message="{project.event.password.length}")
	private String password;
	
	private boolean active;
	
	@ManyToMany
	@JoinTable(name="user_role")
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", surname=" + surname + ", password="
				+ password + ", active=" + active + ", roles=" + roles + "]";
	}

	public User(int id, String email, String name, String surname, String password, boolean active,
			Set<project.event.model.Role> roles) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public User(String email, String name, String surname, String password, boolean active,
			Set<project.event.model.Role> roles) {
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public User() {
	}
	
	
	
}