package controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Book;
import modelo.Categories;
import servicios.CategoriesService;

@Controller
@RequestMapping("admin/")
public class CategoriesAdminController {

	@Autowired
	CategoriesService categoriesService;

	@RequestMapping("/listCategories")
	public String listCategories(Model model) {
		model.addAttribute("categories", categoriesService.getCategories());
		return "/admin/listarCategorias";
	}
	
	@RequestMapping("/deleteCategory")
	public String deleteCategory(String id, Model model) {
		categoriesService.deleteCategory(Long.parseLong(id));
		return listCategories(model);
	}
	
	@RequestMapping("/editCategory")
	public String editCategory(String id, Model model) {
		Categories category = categoriesService.getCategoryById(Long.parseLong(id));
		model.addAttribute("category", category);
		return "/admin/editarCategoria";
	}
	
	@RequestMapping("/saveCategoryChanges")
	public String saveCategoryChanges(Categories category, Model model) {
		categoriesService.saveCategoryChanges(category);
		return listCategories(model);
	}

	@RequestMapping("/registerCategory")
	public String registerCategory(Model model) {
		model.addAttribute("category", new Categories());
		return "/admin/registrarCategoria";
	}

	@RequestMapping("/saveNewCategory")
	public String saveNewCategory(Categories newCategory, Model model) {
		categoriesService.registerCategory(newCategory);
		return listCategories(model);
	}
}
