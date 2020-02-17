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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Users")
public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwordHash=" + passwordHash + ", userGroup=" + userGroup
				+ "]";
	}

	public User(Long id, @NotEmpty(message = "User name is required") @Length(max = 50) String name,
			@NotEmpty(message = "Password is required") @Length(max = 100) String passwordHash,
			@NotEmpty(message = "User group is required") UserGroup userGroup) {
		super();
		this.id = id;
		this.name = name;
		this.passwordHash = passwordHash;
		this.userGroup = userGroup;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	@JoinColumn(name = "userGroup_ID")
	private UserGroup userGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
