
package com.eonAcademy.demy2.Service;

import com.eonAcademy.demy2.Entity.Userr;
import com.eonAcademy.demy2.auth.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Long>{

}
