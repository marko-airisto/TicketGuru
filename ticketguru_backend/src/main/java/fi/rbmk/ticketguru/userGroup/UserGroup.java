package fi.rbmk.ticketguru.userGroup;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import fi.rbmk.ticketguru.user.User;

@Entity
@Table(name = "UserGroups")
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userGroup_ID")
	private Long id;

	@NotEmpty(message = "User group name is required")
	@Length(max = 100)
	@Column(name = "name")
	private String name;

	@NotNull(message = "User group is required")
	@JsonIgnore
	@OneToMany(mappedBy = "userGroup")
	private List<User> users;

	public UserGroup() {
	}

	public UserGroup(UserGroup userGroup) {
	}

	// Getters

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	// Setters

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}
}
