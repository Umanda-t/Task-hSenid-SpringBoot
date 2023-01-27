package com.example.assignment.controller;

import com.example.assignment.model.Students;
import com.example.assignment.repository.StudentsRepository;
import com.example.assignment.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
public class StudentsController {

    private StudentsRepository repo;
    private StudentsService service;

    public StudentsController(StudentsRepository repo,
                              StudentsService service) {
        this.repo = repo;
        this.service = service;
    }


    @PostMapping("addStudent")
    public Students AddStudent(@RequestBody Students s ){

        return this.service.saveStudent(s);
    }



    @GetMapping("allStudents")
    public List<Students> getAllStudents() {

        return this.service.getStudentsList();
    }

    @GetMapping("getname/{id}")
    public String getNameStudents(@PathVariable Long id) {

        return this.service.getStudentName(id);
    }

    @DeleteMapping("deleteStudent/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PutMapping("/studentupdate/{id}")
    public ResponseEntity<?> update(@RequestBody Students students, @PathVariable Long id) {
        try {
            //Students s = service.get(id);
            service.saveStudent(students);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
