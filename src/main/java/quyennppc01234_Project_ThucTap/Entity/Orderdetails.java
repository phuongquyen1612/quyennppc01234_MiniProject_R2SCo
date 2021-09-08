package quyennppc01234_Project_ThucTap.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Orderdetails implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer detailid;
	Integer ordid;
	String prodid;
	String productname;
	Integer price;
	Integer qty;
	
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "ordid", insertable = false, updatable = false)
	Orders orders;
	
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "prodid", insertable = false, updatable = false)
	Products products;
	
	
}
