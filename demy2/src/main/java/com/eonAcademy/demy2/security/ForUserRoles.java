package com.eonAcademy.demy2.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.eonAcademy.demy2.security.ForUserPermissions.*;

public enum ForUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSES_READ,COURSES_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(STUDENT_READ, COURSES_READ));

    private final Set<ForUserPermissions> permissions;
//   ADMIN       Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSES_READ,COURSES_WRITE) = permissions
    ForUserRoles(Set<ForUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<ForUserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
  // Array<SimpleGrantedAuthority> permissions = Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSES_READ,COURSES_WRITE).
     //                                                                       new SimpleGrantedAuthority("courses:write").collectToSet(i.e make to be like an array at the end)
       Set<SimpleGrantedAuthority> permissions = getPermissions().stream().map(permission ->
                new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
       //permissions.add(i.e A role to it)
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;

        //AT THE END, something like this will occur
        //Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSES_READ,COURSES_WRITE).
        //     //                                                                  new SimpleGrantedAuthority("courses:write").collectToSet(i.e make to be like an array at the end)
            //                                                                  . role(i.e Any role you put)
    }
}
