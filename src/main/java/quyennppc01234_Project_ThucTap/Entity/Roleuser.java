package quyennppc01234_Project_ThucTap.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="roleuser")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Roleuser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String username;
	public String roleid;
	
	@ManyToOne
	@JoinColumn(name="username", insertable = false, updatable = false)
	Users user;
	
	@ManyToOne
	@JoinColumn(name="roleid", insertable = false, updatable = false)
	Roles role;
}
