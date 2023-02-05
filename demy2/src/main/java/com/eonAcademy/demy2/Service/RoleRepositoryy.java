package com.eonAcademy.demy2.Service;

import com.eonAcademy.demy2.Entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoryy extends JpaRepository<Userr, Long>{

}
