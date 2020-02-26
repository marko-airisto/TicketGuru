package fi.rbmk.ticketguru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

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
	private String passwordHash;

	@NotEmpty(message = "User group is required")
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userGroup_ID")
	private UserGroup userGroup;

	public User() {

	}

	public User(User user) {
	}

	public User(String name, String passwordHash, UserGroup userGroup) {
		this.name = name;
		this.passwordHash = passwordHash;
		this.userGroup = userGroup;
	}

	// Getters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	// Setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
