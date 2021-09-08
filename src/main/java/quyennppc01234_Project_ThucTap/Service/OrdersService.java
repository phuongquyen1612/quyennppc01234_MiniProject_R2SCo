package quyennppc01234_Project_ThucTap.Service;

import java.security.Principal;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import quyennppc01234_Project_ThucTap.Entity.Orders;


public interface OrdersService {

	List<Orders> findAll();

	boolean existsById(Integer id);

	Orders findById(Integer id);

	Orders create(JsonNode order, Principal pin);

	List<Orders> findAllByCustomer(String email);

	List<Orders> findAllByEmail(String name);

	

}
