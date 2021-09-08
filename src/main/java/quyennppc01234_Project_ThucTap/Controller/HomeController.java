package quyennppc01234_Project_ThucTap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import quyennppc01234_Project_ThucTap.Entity.Products;
import quyennppc01234_Project_ThucTap.Service.ProductsService;


@Controller
@RequestMapping("/quyenshop")
public class HomeController {
	@Autowired
	ProductsService productService;
	
	@RequestMapping("/index")
	public String index(Model m) {
		List<Products> product = productService.findAll();
		for (Products item : product) {
			System.out.println(item.getProductname());
		}
		m.addAttribute("product", productService.findAll());
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/add-to-wishlist")
	public String addToWishList() {
		return "add-to-wishlist";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	@RequestMapping("/order-complete")
	public String ordcomp() {
		return "order-complete";
	}
	
	
	
	
	
}