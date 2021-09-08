package quyennppc01234_Project_ThucTap.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quyennppc01234_Project_ThucTap.Entity.Orderdetails;


@Repository
public interface OrderDetails_DAO extends JpaRepository<Orderdetails, Integer>{

	List<Orderdetails> findAllByOrdid(Integer id);

}
