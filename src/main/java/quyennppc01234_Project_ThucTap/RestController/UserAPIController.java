package quyennppc01234_Project_ThucTap.RestController;

import java.util.Collection;
import java.util.List;

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
import quyennppc01234_Project_ThucTap.Entity.Users;
import quyennppc01234_Project_ThucTap.Service.UsersService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quyenshop/admin/users") 
public class UserAPIController {
	@Autowired UsersService userService;        
	
	@GetMapping
	ResponseEntity<Collection<Users>> get(){
		System.out.println(userService.findAll().size());
		return ResponseEntity.ok(userService.findAll());
	}
	 
	@GetMapping("/{username}") 
	ResponseEntity<Users> getid(@PathVariable("username") String username){
		if(!userService.existByUsername(username)) {
			return ResponseEntity.notFound().build();  
		}
		return ResponseEntity.ok(userService.findByUsernameLike(username));
	}
	
	@PostMapping
	ResponseEntity<Users> post(@RequestBody Users us, @PathVariable("username") String username) {
		System.out.println(us.toString());
		if(userService.existByUsername(us.getUsername())) {
			us.setUsername(username);;
			userService.save(us);
			
			return ResponseEntity.ok(us);
		}
		userService.save(us);
		return ResponseEntity.ok(us);
	}
	
	@PutMapping("/{username}")
	ResponseEntity<Users> put(@RequestBody Users us, @PathVariable("username") String username){
		if(!userService.existByUsername(username)) {
			userService.save(us);
			return ResponseEntity.ok(us);
		}
		return ResponseEntity.notFound().build();
	} 
	
	@DeleteMapping("/{username}")
	ResponseEntity<Void> delete(@PathVariable("id") String username) {
		if (userService.existByUsername(username)) {
			userService.deleteById(username);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();           

	}
	

}
