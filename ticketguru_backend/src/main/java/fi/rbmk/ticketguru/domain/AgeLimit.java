package fi.rbmk.ticketguru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="AgeLimits")
public class AgeLimit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ageLimit_ID")
	private Long id;

	@NotEmpty(message = "Age limit must be set")
	@Length(max = 50)
	@Column(name = "name")
	private String name;
	
	@Length(max = 500)
	@Column(name = "specifier")
	private String specifier;
	
	public AgeLimit() {}
	
	public AgeLimit(AgeLimit ageLimit) {}
	
	public AgeLimit(String name) {
		this.name = name;
	}
	
	public AgeLimit(String name, String specifier) {
		this.name = name;
		this.specifier = specifier;
	}
	
	public Long getId() { return this.id; }
	public String getName() { return this.name; }
	public String getSpecifier() { return this.specifier; }
	
	public void setName(String name) { this.name = name; }
	public void setSpecifier(String specifier) { this.specifier = specifier; }
	
}