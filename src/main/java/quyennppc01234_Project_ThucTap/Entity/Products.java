package quyennppc01234_Project_ThucTap.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.utility.RandomString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Products implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String productid = RandomString.make(15);
	String productname;
	String image;
	Integer price=1;
	Integer sale=0;
	Integer newprice;
	String description;
	Integer ctgid;
	  
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JoinColumn(name="ctgid", insertable = false, updatable = false)
	Categories categories;  
	
	
	@OneToMany(mappedBy = "products")
	@JsonIgnore
	List<Orderdetails> orderdetails;
	

}
