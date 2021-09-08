package quyennppc01234_Project_ThucTap.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quyennppc01234_Project_ThucTap.DAO.OrderDetails_DAO;
import quyennppc01234_Project_ThucTap.Entity.Orderdetails;
import quyennppc01234_Project_ThucTap.Service.OrderDetailsService;


@Service
public class OrderDetailsServiceImp implements OrderDetailsService {
	@Autowired
	OrderDetails_DAO orderdetaildao;

	@Override
	public void saveAll(List<Orderdetails> details) {
		orderdetaildao.saveAll(details);
	}

	@Override
	public List<Orderdetails> findAllByOrdid(Integer id) {
		// TODO Auto-generated method stub
		return orderdetaildao.findAllByOrdid(id);
	}

}
