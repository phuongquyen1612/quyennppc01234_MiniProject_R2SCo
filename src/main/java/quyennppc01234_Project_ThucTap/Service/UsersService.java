package quyennppc01234_Project_ThucTap.Service;


import java.util.List;

import quyennppc01234_Project_ThucTap.Entity.Users;


public interface UsersService {
	Users findByUsernameLike(String username);

	List<Users> getAdministrators();

	List<Users> findAll();

	boolean existByUsername(String username);

	void save(Users us);

	void deleteById(String username);

	
}
