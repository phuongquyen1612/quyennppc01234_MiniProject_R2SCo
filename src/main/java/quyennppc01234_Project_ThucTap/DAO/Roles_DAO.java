package quyennppc01234_Project_ThucTap.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quyennppc01234_Project_ThucTap.Entity.Roles;


@Repository
public interface Roles_DAO extends JpaRepository<Roles, String> {

}
