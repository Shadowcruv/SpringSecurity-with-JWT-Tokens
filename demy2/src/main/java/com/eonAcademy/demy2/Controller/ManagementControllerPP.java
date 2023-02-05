package com.eonAcademy.demy2.Controller;


import com.eonAcademy.demy2.Entity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/management/api/student")
@RestController
public class ManagementControllerPP {

    List<Student> col = new ArrayList();

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getStudents(){

        Student ist = new Student("Nanu", "Tall");

        Student fourth = new Student ("Nene", "medium");


        col.add(ist);

        col.add(fourth);

        return col;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('studet:write')")
    public void addStudent(@RequestBody Student student){
        System.out.println(student);
        col.add(student);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:read')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){

        System.out.println(studentId + " " + student);

    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
        col.remove(studentId - 1);
        System.out.println("deleted student");
    }


}
