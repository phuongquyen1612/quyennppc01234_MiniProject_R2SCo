package quyennppc01234_Project_ThucTap.Service;

import java.util.List;

import quyennppc01234_Project_ThucTap.Entity.Orderdetails;


public interface OrderDetailsService {

	void saveAll(List<Orderdetails> details);

	List<Orderdetails> findAllByOrdid(Integer id);

}
