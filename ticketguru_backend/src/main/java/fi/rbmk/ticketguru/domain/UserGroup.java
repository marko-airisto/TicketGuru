package fi.rbmk.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class UserGroup {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long userGroup_ID;
	private String userGroupName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userGroup_ID")
	private List<User> users;

	public Long getUserGroup_ID() {
		return userGroup_ID;
	}

	public void setUserGroup_ID(Long userGroup_ID) {
		this.userGroup_ID = userGroup_ID;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserGroup [userGroup_ID=" + userGroup_ID + ", userGroupName=" + userGroupName + ", users=" + users
				+ "]";
	}

	public UserGroup(Long userGroup_ID, String userGroupName, List<User> users) {
		super();
		this.userGroup_ID = userGroup_ID;
		this.userGroupName = userGroupName;
		this.users = users;
	}

	public UserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

}
