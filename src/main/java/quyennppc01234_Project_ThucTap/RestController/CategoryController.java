package quyennppc01234_Project_ThucTap.RestController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quyennppc01234_Project_ThucTap.Entity.Categories;
import quyennppc01234_Project_ThucTap.Service.CategoriesService;

@RestController
@RequestMapping("/quyenshop/admin/ctgry")
public class CategoryController {
	@Autowired
	CategoriesService ctgryService;
	
	@GetMapping
	ResponseEntity<Collection<Categories>> get() {
		return ResponseEntity.ok(ctgryService.findAll());
	}
	
}
