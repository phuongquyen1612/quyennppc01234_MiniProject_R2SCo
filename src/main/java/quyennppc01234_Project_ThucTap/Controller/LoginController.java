package quyennppc01234_Project_ThucTap.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quyenshop/login")
public class LoginController {
	@GetMapping
	public String login(Authentication auth) {
		return auth==null ? "login2":"redirect:/quyenshop/index";
	}
}
