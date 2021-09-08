package quyennppc01234_Project_ThucTap.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quyennppc01234_Project_ThucTap.Entity.Roleuser;
import quyennppc01234_Project_ThucTap.Entity.Users;


@Repository
public interface RoleuserDAO extends JpaRepository<Roleuser, Integer>{
	@Query("SELECT DISTINCT a FROM Roleuser a WHERE a.user IN ?1")
	List<Roleuser> authoritiesOf(List<Users> accounts);
	
}
