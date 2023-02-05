package com.eonAcademy.demy2.security;

public enum ForUserPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSES_READ("courses:read"),
    COURSES_WRITE("courses:write");

    private final String permissions;

//  COURSES_WRITE      ("courses:write");
    ForUserPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermission() {
     //        "courses:write"
        return permissions;
    }
}
