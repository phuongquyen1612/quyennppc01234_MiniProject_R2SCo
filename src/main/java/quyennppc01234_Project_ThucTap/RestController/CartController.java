package quyennppc01234_Project_ThucTap.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quyennppc01234_Project_ThucTap.Entity.Products;
import quyennppc01234_Project_ThucTap.Service.ProductsService;


@CrossOrigin("*")
@RestController
@RequestMapping("/quyenshop/customer/product")
public class CartController {
	@Autowired
	ProductsService productService;

	@GetMapping("/{id}")
	public ResponseEntity<Products> getid(@PathVariable("id") String id) {
		if (!productService.existsById(id)) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok(productService.findByProductidLike(id)); 
	}

}
