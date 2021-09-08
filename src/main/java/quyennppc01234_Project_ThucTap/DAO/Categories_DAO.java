package quyennppc01234_Project_ThucTap.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quyennppc01234_Project_ThucTap.Entity.Categories;


@Repository
public interface Categories_DAO extends JpaRepository<Categories, Integer>{

}
