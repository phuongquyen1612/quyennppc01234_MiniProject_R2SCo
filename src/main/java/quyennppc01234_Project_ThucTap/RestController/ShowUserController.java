package quyennppc01234_Project_ThucTap.RestController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quyennppc01234_Project_ThucTap.Entity.Users;
import quyennppc01234_Project_ThucTap.Service.UsersService;


@RestController
@CrossOrigin("*")
@RequestMapping("/quyenshop")
public class ShowUserController {
	@Autowired UsersService userService;
	
	@GetMapping("/user")
	public Users getOne(Principal p) {
		return userService.findByUsernameLike(p.getName());
	}
	
	@GetMapping("/admin/user")
	public Users getAdmin(Principal p) {
		return userService.findByUsernameLike(p.getName());
	}
}
