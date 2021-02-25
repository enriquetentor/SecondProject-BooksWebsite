package controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Categories;
import modelo.User;
import servicios.UsersService;

@Controller
@RequestMapping("admin/")
public class UsersAdminController {

	@Autowired
	UsersService usersService;
	
	@RequestMapping("/listUsers")
	public String listUsers(Model model) {
		model.addAttribute("users", usersService.getAllUsers());
		return "/admin/listarUsuarios";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(Model model) {
		model.addAttribute("user", new User());
		return "/admin/registrarUsuario";
	}
	
	@RequestMapping("/saveNewUser")
	public String saveNewUser(User newUser, Model model) {
		usersService.registerUser(newUser);
		return listUsers(model);
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(String id, Model model) {
		usersService.deleteUser(Long.parseLong(id));
		return listUsers(model);
	}

	@RequestMapping("/editUser")
	public String editUser(String id, Model model) {
		User user = usersService.getUserById(Long.parseLong(id));
		model.addAttribute("user", user);
		return "/admin/editarUsuario";
	}

	@RequestMapping("/saveUserChanges")
	public String saveUserChanges(User user, Model model) {
		usersService.saveUserChanges(user);
		return listUsers(model);
	}
	
}
