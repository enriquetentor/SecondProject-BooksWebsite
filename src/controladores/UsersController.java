package controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.User;
import servicios.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService servicioUsuarios;

	@RequestMapping("prepararIdentificacionUsuario")
	public String prepararIdentificacionUsuario(Model model) {
		return "loginUsuario";
	}

	@RequestMapping("loginUsuario")
	public String loginUsuario(@RequestParam("name") String name, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		User user = servicioUsuarios.getUserByNameAndPassword(name, password);
		if (user != null) {
			request.getSession().setAttribute("idUser", user.getId());
			request.getSession().setAttribute("name", user.getName());
			return "bienvenidoUsuario";
		} else {
			model.addAttribute("mensaje", "Email o contraseña incorrectos");
			return "loginUsuario";
		}
	}

	@RequestMapping("cerrarSesionUsuario")
	public String cerrarSesionUsuario(HttpServletRequest request) {
		request.getSession().invalidate();
		return "logoutUsuario";
	}

	@RequestMapping("prepararRegistroUsuario")
	public String prepararRegistroUsuario(Model model) {
		model.addAttribute("nuevoUsuario", new User());
		return "registroUsuario";
	}

	@RequestMapping("guardarNuevoUsuario")
	public String guardarNuevoUsuario(User nuevoUsuario) {
		servicioUsuarios.registerUser(nuevoUsuario);
		return "registroUsuarioOk";
	}
}
