package fi.rbmk.ticketguru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_ID", nullable = false, updatable = false)
	    private Long id;

	    // Username with unique constraint
	    @Column(name = "UserName", nullable = false, unique = true)
	    private String userName;

	    @Column(name = "Password", nullable = false)
	    private String passwordHash;

	    @ManyToOne
		@JoinColumn(name = "userGroup_ID")
	    private UserGroup userGroup;

	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
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

	@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", passwordHash=" + passwordHash + ", userGroup="
					+ userGroup + "]";
		}

	public User(Long id, String userName, String passwordHash, UserGroup userGroup) {
			super();
			this.id = id;
			this.userName = userName;
			this.passwordHash = passwordHash;
			this.userGroup = userGroup;
		}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
