package quyennppc01234_Project_ThucTap.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quyennppc01234_Project_ThucTap.Entity.Users;


@Repository
public interface Users_DAO extends JpaRepository<Users, String> {
	Users findByUsernameLike(String username);

	@Query("SELECT DISTINCT ar.user FROM Roleuser ar")
	public List<Users> getAdministrators();


	boolean existsByUsername(String username);

	
	

}
