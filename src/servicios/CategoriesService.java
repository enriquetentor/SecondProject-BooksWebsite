package servicios;

import java.util.List;
import java.util.Map;

import modelo.Categories;

public interface CategoriesService {
	
	public void registerCategory(Categories categories);
	public List<Categories> getCategories();
	public List<Map<String, Object>> getCategoriesToList();
	public void deleteCategory(long categoryId);
	public Categories getCategoryById(long categoryId);
	public void saveCategoryChanges(Categories category);

}
