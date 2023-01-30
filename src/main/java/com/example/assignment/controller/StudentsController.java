package com.example.assignment.controller;

import com.example.assignment.model.Students;
import com.example.assignment.repository.StudentsRepository;
import com.example.assignment.service.StudentsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class StudentsController {


    private StudentsService service;

    public StudentsController(StudentsService service) {

        this.service = service;
    }


    @PostMapping("addStudent")
    public ResponseEntity<Students> AddStudent(@RequestBody Students s ){

        Students o= this.service.saveStudent(s);
        return ResponseEntity.ok().body(o);
    }



    @GetMapping("allStudents")
    public ResponseEntity<List<Students>> getAllStudents() {

        List<Students> o=service.getStudentsList();
        return ResponseEntity.ok(o);
    }

    @GetMapping("getname/{id}")
    public ResponseEntity<String> getNameStudents(@PathVariable Long id) {

        String n=service.getStudentName(id);
        return ResponseEntity.ok(n);
    }

    @DeleteMapping("deleteStudent/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PutMapping("/studentupdate/{id}")
    public ResponseEntity<String> update(@RequestBody Students students, @PathVariable Long id) {
        try {
            //Students s = service.get(id);
            service.saveStudent(students);
            return ResponseEntity.ok("Success");
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("Fail");
        }
    }

//    @PostMapping("addStudent")
//    public Students AddStudent(@RequestBody Map<String, Object> payload ){
//        Students s=new Students();
//        String name= String.valueOf(payload.get("name"));
//        String grade= String.valueOf(payload.get("grade"));
//
//        s.setName(name);
//        s.setGrade(grade);
//
//       return this.service.saveStudent(s);
//    }

}
