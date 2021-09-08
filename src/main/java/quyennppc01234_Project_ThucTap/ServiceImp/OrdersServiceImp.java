package quyennppc01234_Project_ThucTap.ServiceImp;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import quyennppc01234_Project_ThucTap.DAO.Orders_DAO;
import quyennppc01234_Project_ThucTap.Entity.Orderdetails;
import quyennppc01234_Project_ThucTap.Entity.Orders;
import quyennppc01234_Project_ThucTap.Service.OrderDetailsService;
import quyennppc01234_Project_ThucTap.Service.OrdersService;
import quyennppc01234_Project_ThucTap.Service.UsersService;



@Service
public class OrdersServiceImp implements OrdersService {
	@Autowired
	Orders_DAO orderdao;
	
	
	@Autowired
	Orders ord;
	
	@Autowired
	OrderDetailsService orderdetailService;

	@Autowired UsersService userService;
	
	@Override
	public List<Orders> findAll() {
		
		return orderdao.findAll();
	}

	@Override
	public boolean existsById(Integer id) {
		
		return orderdao.existsById(id);
	}

	@Override
	public Orders findById(Integer id) {
		
		return orderdao.findById(id).get();
	}

	@Override
	public Orders create(JsonNode order, Principal p) {
		 ObjectMapper mapper=new ObjectMapper();
//		 hd=mapper.convertValue(hoadons,hoadon.class );
		 ord.setEmail(p.getName());
		 ord.setFullname(order.get("fullname").asText());
		 ord.setAddress(order.get("address").asText());
		 ord.setPhone(order.get("phone").asText());
		 ord.setTotal(order.get("total").asInt());
		 
		 
		 orderdao.save(ord);
		 
		 TypeReference<List<Orderdetails>>type=new TypeReference<List<Orderdetails>>() {
		
		 };
		
		 List<Orderdetails>details=mapper.convertValue(order.get("orderDetail"), type)
				 .stream().peek(d->d.setOrders(ord)).collect(Collectors.toList());
		 System.out.println(details.toString());
		 details.forEach(s->{
			 s.setOrdid(ord.getOrderid());
		 });
		 orderdetailService.saveAll(details);
			return ord;
	}

	@Override
	public List<Orders> findAllByCustomer(String email) {
		// TODO Auto-generated method stub
		return orderdao.findAllByEmailOrderByOrderidDesc(email);
	}

	@Override
	public List<Orders> findAllByEmail(String name) {
		// TODO Auto-generated method stub
		return orderdao.findAllByEmail(name);
	}

	
	
	

	
}
