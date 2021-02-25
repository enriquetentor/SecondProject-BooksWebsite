package controladores.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/")
public class LoginAdminController {

	@RequestMapping("")
	public String login() {
		return "/admin/login";
	}

	@RequestMapping("/loginAdmin")
	public String identificarAdmin(String pass, Model model) {
		if (pass.equals("123")) {
			return "/admin/bienvenido";
		} else {
			model.addAttribute("mensaje", "Password incorrecta");
			return "/admin/login";
		}
	}
}
