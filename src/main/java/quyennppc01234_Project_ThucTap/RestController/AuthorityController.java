package quyennppc01234_Project_ThucTap.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quyennppc01234_Project_ThucTap.Entity.Roleuser;
import quyennppc01234_Project_ThucTap.Service.AuthorityService;



@RestController
@RequestMapping("/rest/authorities")
public class AuthorityController {
	@Autowired
	AuthorityService authService;
	
	@GetMapping 
	List<Roleuser> findAll(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return authService.findAuthoritiesOfAdministrators();
		}
		return authService.findAll();
	}
	 
	@PostMapping
	public Roleuser post(@RequestBody Roleuser auth) {
		System.out.println(auth.toString());
		return authService.create(auth);
	}
	 
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		authService.delete(id);
	}
}
