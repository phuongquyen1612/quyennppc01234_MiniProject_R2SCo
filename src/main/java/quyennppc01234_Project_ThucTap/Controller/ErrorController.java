package quyennppc01234_Project_ThucTap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quyenshop")
public class ErrorController {
	@GetMapping("/403")
	public String error403() {
		return "403";
	}
}
