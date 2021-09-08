package quyennppc01234_Project_ThucTap.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Orders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderid;
	String email;
	String fullname;
	Integer total;
	String address;
	String phone;
	
	@OneToMany(mappedBy = "orders")
	@JsonIgnore
	List<Orderdetails> orddetail;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="email", insertable = false, updatable = false )
	Users user;

}
