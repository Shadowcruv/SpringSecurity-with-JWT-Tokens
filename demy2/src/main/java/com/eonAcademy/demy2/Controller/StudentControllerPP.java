package com.eonAcademy.demy2.Controller;

import com.eonAcademy.demy2.Entity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentControllerPP {


    @GetMapping("/school")
    public String getAllStudents(){
       return "Hello School";
    }
    @GetMapping("/building")
    public String getAllStudent(){
        return "Building School";
    }

    @GetMapping("/loginju")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<Student> getStudent(){

        Student ist = new Student("Nanu", "Tall");
        Student second = new Student ("Jerry", "Tall");
        List<Student> col = new ArrayList();

        col.add(ist);
        col.add(second);

        return col;
    }




}
