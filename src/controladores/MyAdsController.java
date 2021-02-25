package controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyAdsController {

	@RequestMapping("misanuncios")
	public String misAnuncios(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("idUser") != null) {
			return "misanuncios/index";
		} else {
			model.addAttribute("mensaje", "Para entrar en 'mis anuncios' debes identificarte.");
			return "loginUsuario";
		}

	}

}
