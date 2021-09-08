package quyennppc01234_Project_ThucTap.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import quyennppc01234_Project_ThucTap.Entity.Users;
import quyennppc01234_Project_ThucTap.Service.UsersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class UserController {
	@Autowired
	UsersService userService;
	
	@GetMapping
	public List<Users> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return userService.getAdministrators();
		}
		return userService.findAll();
	}
	
	
	
	
	
	
		
}
