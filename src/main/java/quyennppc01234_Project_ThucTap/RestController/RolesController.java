package quyennppc01234_Project_ThucTap.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quyennppc01234_Project_ThucTap.Entity.Roles;
import quyennppc01234_Project_ThucTap.Service.RolesService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RolesController {
	@Autowired
	RolesService roleService;
	
	@GetMapping
	public List<Roles> getAll(){
		return roleService.findAll();
	}
}
