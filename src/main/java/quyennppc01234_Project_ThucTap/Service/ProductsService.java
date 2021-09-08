package quyennppc01234_Project_ThucTap.Service;

import java.util.List;

import quyennppc01234_Project_ThucTap.Entity.Products;


public interface ProductsService {

	List<Products> findAll();

	Products findById(String getid);

	boolean existsById(String id);

	
	                                                 
	Products findByProductidLike(String id);

	boolean existsById(Integer id);

	Products findById(Integer id);

	void save(Products ctgry);

	void deleteById(String id);

	List<Products> findByCtgid(Integer integer);

}
