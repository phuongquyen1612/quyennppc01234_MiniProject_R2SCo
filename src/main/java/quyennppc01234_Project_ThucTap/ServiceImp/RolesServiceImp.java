package quyennppc01234_Project_ThucTap.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quyennppc01234_Project_ThucTap.DAO.Roles_DAO;
import quyennppc01234_Project_ThucTap.Entity.Roles;
import quyennppc01234_Project_ThucTap.Service.RolesService;


@Service
public class RolesServiceImp implements RolesService {
	@Autowired Roles_DAO roleDAO;

	@Override
	public List<Roles> findAll() {
		return roleDAO.findAll();
	}

}
