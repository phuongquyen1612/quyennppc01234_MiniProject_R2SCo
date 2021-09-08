package quyennppc01234_Project_ThucTap.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quyennppc01234_Project_ThucTap.DAO.Users_DAO;
import quyennppc01234_Project_ThucTap.Entity.Users;
import quyennppc01234_Project_ThucTap.Service.UsersService;


@Service
public class UsersServiceImp implements UsersService {
	@Autowired
	Users_DAO userdao;

	@Override
	public Users findByUsernameLike(String username) {		
		return userdao.findByUsernameLike(username);
	}

	@Override
	public List<Users> getAdministrators() {
		return userdao.getAdministrators();
	}

	@Override
	public List<Users> findAll() {
		return userdao.findAll();
	}

	@Override
	public boolean existByUsername(String username) {
		// TODO Auto-generated method stub
		return userdao.existsByUsername(username);
	}

	@Override
	public void save(Users us) {
		userdao.save(us);	
	}

	@Override
	public void deleteById(String username) {
		userdao.deleteById(username);
		
	}

	
	

}
