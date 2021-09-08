package quyennppc01234_Project_ThucTap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quyenshop/admin/home") 
public class AdminController {
	@RequestMapping
	public String admin() {
		return "redirect:/admin/layout.html"; 
	} 
	 
	
	
}
