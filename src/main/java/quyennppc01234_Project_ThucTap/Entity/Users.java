package quyennppc01234_Project_ThucTap.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Users implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	public String username;
	public String password;
	public Boolean activated = false;
	public String verifycode;
	public String fullname;     

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JoinTable(name = "roleuser", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	public List<Roles> role = new ArrayList<Roles>();

	@OneToOne(mappedBy = "user")
	@JsonIgnore
	Orders order;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Roleuser> rouuser;
}
