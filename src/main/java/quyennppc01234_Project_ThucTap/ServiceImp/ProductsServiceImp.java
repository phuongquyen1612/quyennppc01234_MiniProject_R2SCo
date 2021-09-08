package quyennppc01234_Project_ThucTap.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quyennppc01234_Project_ThucTap.DAO.Products_DAO;
import quyennppc01234_Project_ThucTap.Entity.Products;
import quyennppc01234_Project_ThucTap.Service.ProductsService;



@Service
public class ProductsServiceImp implements ProductsService {
	@Autowired
	Products_DAO productdao;

	@Override
	public List<Products> findAll() {
		return productdao.findAll();
	}

	@Override
	public Products findById(String getid) {
		return productdao.findById(getid).get();
	}

	@Override
	public boolean existsById(String id) {
		return productdao.existsById(id);
	}

	@Override
	public Products findByProductidLike(String id) {
		return productdao.findByProductidLike(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}

	@Override
	public Products findById(Integer id) {
		return null;
	}

	@Override
	public void save(Products ctgry) {
		productdao.save(ctgry);
	}

	@Override
	public void deleteById(String id) {
		productdao.deleteById(id);
	}

	@Override
	public List<Products> findByCtgid(Integer integer) {
		return productdao.findAllByCtgid(integer);
	}

	

}
