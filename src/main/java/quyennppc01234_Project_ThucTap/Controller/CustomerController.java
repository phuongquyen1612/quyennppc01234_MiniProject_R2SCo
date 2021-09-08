package quyennppc01234_Project_ThucTap.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import quyennppc01234_Project_ThucTap.Service.OrderDetailsService;
import quyennppc01234_Project_ThucTap.Service.OrdersService;


@Controller
@RequestMapping("/quyenshop/customer")
public class CustomerController {
	@Autowired
	OrdersService orderService;
	
	
	@Autowired
	OrderDetailsService detailService;
	
	@RequestMapping("/home")
	public String customer() {
		return "index";
	}
	
	@RequestMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	
	@RequestMapping("/order-complete")
	public String ordercomplete() {
		return "order-complete";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/order")
	public String order(Model m, Principal p) {
		m.addAttribute("order", orderService.findAllByEmail(p.getName()));
		return "order";
	}
	
	@GetMapping("/order/{id}")
	public String ord(Model m, @PathVariable("id") Integer id, Principal p) {
		m.addAttribute("detail", detailService.findAllByOrdid(id));
		return order(m, p);
	}
	
	
}
