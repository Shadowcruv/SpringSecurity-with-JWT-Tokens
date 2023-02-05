package com.eonAcademy.demy2.auth;

import com.eonAcademy.demy2.Entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectUserByUserName(String userName);

}
