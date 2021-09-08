package quyennppc01234_Project_ThucTap.RestController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;
import quyennppc01234_Project_ThucTap.Entity.Products;
import quyennppc01234_Project_ThucTap.Service.ProductsService;


@CrossOrigin("*")
@RestController
@RequestMapping("/quyenshop/admin/pd") 
public class ProductController {
	@Autowired
	ProductsService pdService;
	
	@GetMapping
	ResponseEntity<Collection<Products>> get() {
		return ResponseEntity.ok(pdService.findAll());
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Products> getid(@PathVariable("id") String id) {
		if (!pdService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pdService.findById(id));
	}
	
	@PostMapping      
	ResponseEntity<Products> post(@RequestBody Products pd) {
		System.out.println(pd.toString());
		if(pdService.existsById(pd.getProductid())) {
			pd.setProductid(RandomString.make(15));
			pdService.save(pd);
			return ResponseEntity.ok(pd);
		}
		pdService.save(pd);
		return ResponseEntity.ok(pd);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Products> put(@PathVariable("id") String id, @RequestBody Products ctgry) {
		if (pdService.existsById(id)) {
			pdService.save(ctgry);
			return ResponseEntity.ok(ctgry);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@PathVariable("id") String id) {
		if (pdService.existsById(id)) {
			pdService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();           

	}
}
