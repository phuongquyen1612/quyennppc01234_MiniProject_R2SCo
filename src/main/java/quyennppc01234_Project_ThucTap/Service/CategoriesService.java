package quyennppc01234_Project_ThucTap.Service;

import java.util.List;

import quyennppc01234_Project_ThucTap.Entity.Categories;

public interface CategoriesService {

	List<Categories> findAll();

	boolean existsById(Integer id);

	Categories findById(Integer id);

	void save(Categories ctgry);

	void deleteById(Integer id);

}
