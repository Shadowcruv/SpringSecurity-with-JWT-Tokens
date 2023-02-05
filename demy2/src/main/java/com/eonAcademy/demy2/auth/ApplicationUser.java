package com.eonAcademy.demy2.auth;

import com.eonAcademy.demy2.Entity.Userr;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;



@Entity
@Table
public class ApplicationUser implements UserDetails {


    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "student_sequence"
    )
    private Long Id;
    private final String userName;
    private final String password;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonEnabled;
    private final boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<? extends GrantedAuthority> authoritiess;




    public ApplicationUser(String userName,
                           String password,
                           Set<? extends GrantedAuthority> authoritiess,
                           boolean isAccountNonExpired,
                           boolean isAccountNonLocked,
                           boolean isCredentialsNonEnabled,
                           boolean isEnabled) {

        this.userName = userName;
        this.password = password;
     //   this.authoritiess = authoritiess;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonEnabled = isCredentialsNonEnabled;
        this.isEnabled = isEnabled;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }


    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonEnabled;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
