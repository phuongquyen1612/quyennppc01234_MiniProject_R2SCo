package quyennppc01234_Project_ThucTap.RestController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import quyennppc01234_Project_ThucTap.Entity.Orders;
import quyennppc01234_Project_ThucTap.Service.OrdersService;


@CrossOrigin
@RestController
@RequestMapping("/quyenshop/customer/ord-cpl")
public class OrderCompleteRestController {
	@Autowired
	OrdersService orderService;
	
	@GetMapping
	public ResponseEntity<List<Orders>> getAll(){
		return ResponseEntity.ok(orderService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Orders>getOne(@PathVariable("id")Integer id){
		if(!orderService.existsById(id)) {
			return ResponseEntity.notFound().build();
			
		}
		return ResponseEntity.ok(orderService.findById(id));
	}
	@PostMapping
	public ResponseEntity<Orders>post(@RequestBody JsonNode  order, Principal pin){
		
		return  ResponseEntity.ok(orderService.create(order,pin));
	}
}
