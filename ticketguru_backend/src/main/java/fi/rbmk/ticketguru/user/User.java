package fi.rbmk.ticketguru.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import fi.rbmk.ticketguru.userGroup.UserGroup;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_ID", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name", unique = true)
	@NotEmpty(message = "User name is required")
	@Length(max = 50)
	private String name;

	@NotEmpty(message = "Password is required")
	@Column(name = "password", nullable = false, unique = true)
	@Length(max = 100)
	private String password;

	@NotNull(message = "User group is required")
	@ManyToOne
	@JoinColumn(name = "userGroup_ID")
	private UserGroup userGroup;

	@NotNull(message = "Active Status is required ")
	@Column(name = "active")
	private Boolean active;

	public User() {

	}

	public User(User user) {
	}

	public User(String name, String password, UserGroup userGroup, Boolean active) {
		this.name = name;
		this.password = password;
		this.userGroup = userGroup;
		this.active = active;
	}

	// Getters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public UserGroup getUserGroups() {
		return userGroup;
	}

	public Boolean getActive() {
		return active;
	}

	// Setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswor(String password) {
		this.password = password;
	}

	public void setUserGroups(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
