package quyennppc01234_Project_ThucTap.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quyennppc01234_Project_ThucTap.DAO.RoleuserDAO;
import quyennppc01234_Project_ThucTap.DAO.Users_DAO;
import quyennppc01234_Project_ThucTap.Entity.Roleuser;
import quyennppc01234_Project_ThucTap.Service.AuthorityService;


@Service
public class AuthorityServiceImp implements AuthorityService{
	@Autowired RoleuserDAO rouDAO;
	@Autowired Users_DAO userDAO;
	
	@Override
	public List<Roleuser> findAll() {
		return rouDAO.findAll();
	}

	@Override
	public List<Roleuser> findAuthoritiesOfAdministrators() {
		return rouDAO.authoritiesOf(userDAO.getAdministrators());
	}

	@Override
	public Roleuser create(Roleuser auth) {
		return rouDAO.save(auth);
	}

	@Override
	public void delete(Integer id) {
		rouDAO.deleteById(id);	
	}
}
