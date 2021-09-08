package quyennppc01234_Project_ThucTap.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quyennppc01234_Project_ThucTap.Entity.Products;


@Repository
public interface Products_DAO extends JpaRepository<Products, String>{

	Products findByProductidLike(String id);

	List<Products> findAllByCtgid(Integer integer);

}
