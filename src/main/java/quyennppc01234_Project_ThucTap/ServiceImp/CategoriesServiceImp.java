package quyennppc01234_Project_ThucTap.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quyennppc01234_Project_ThucTap.DAO.Categories_DAO;
import quyennppc01234_Project_ThucTap.Entity.Categories;
import quyennppc01234_Project_ThucTap.Service.CategoriesService;

@Service
public class CategoriesServiceImp implements CategoriesService {
	@Autowired
	Categories_DAO categorydao;

	@Override
	public List<Categories> findAll() {
		// TODO Auto-generated method stub
		return categorydao.findAll();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return categorydao.existsById(id);
	}

	@Override
	public Categories findById(Integer id) {
		// TODO Auto-generated method stub
		return categorydao.getById(id);
	}

	@Override
	public void save(Categories ctgry) {
		categorydao.save(ctgry);
	}

	@Override
	public void deleteById(Integer id) {
		categorydao.deleteById(id);
		
	}

}
