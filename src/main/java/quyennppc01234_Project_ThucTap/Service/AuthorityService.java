package quyennppc01234_Project_ThucTap.Service;

import java.util.List;

import quyennppc01234_Project_ThucTap.Entity.Roleuser;

public interface AuthorityService {

	List<Roleuser> findAll();

	Roleuser create(Roleuser auth);

	void delete(Integer id);

	List<Roleuser> findAuthoritiesOfAdministrators();

}
