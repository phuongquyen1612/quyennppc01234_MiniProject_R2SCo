package quyennppc01234_Project_ThucTap.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quyennppc01234_Project_ThucTap.Entity.Orders;


@Repository
public interface Orders_DAO extends JpaRepository<Orders, Integer>{

	List<Orders> findAllByEmailOrderByOrderidDesc(String email);

	List<Orders> findAllByEmail(String name);

}
