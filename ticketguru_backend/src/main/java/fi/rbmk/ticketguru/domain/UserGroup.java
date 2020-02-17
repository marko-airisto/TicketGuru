package fi.rbmk.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "UserGroups")
public class UserGroup {
	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", name=" + name + ", users=" + users + "]";
	}

	public UserGroup(Long id, @NotEmpty(message = "User group name is required") @Length(max = 1000) String name,
			List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public UserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userGroup_ID")
	private Long id;

	@NotEmpty(message = "User group name is required")
	@Length(max = 100)
	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private List<User> users;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
