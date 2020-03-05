package fi.rbmk.ticketguru.userGroup;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import fi.rbmk.ticketguru.user.User;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)

@Entity
@Table(name = "UserGroups")
public class UserGroup {

	@PrePersist
	@PreUpdate
	public void populateUsers() {
		for (User user : this.users) {
			user.setUserGroup(this);
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userGroup_ID")
	private Long id;

	@NotEmpty(message = "User group name is required")
	@Length(max = 100)
	@Column(name = "name")
	private String name;

	// @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userGroup")
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

	public List<User> getUser() {
		return users;
	}

	// Setters

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
