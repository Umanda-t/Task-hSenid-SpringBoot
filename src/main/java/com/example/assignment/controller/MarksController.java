package com.example.assignment.controller;

import com.example.assignment.model.Marks;
import com.example.assignment.model.Students;
import com.example.assignment.service.MarksService;
import com.example.assignment.service.StudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
public class MarksController {
    private MarksService service;
    private StudentsService studentservice;

    public MarksController(MarksService service, StudentsService studentservice) {
        this.service = service;
        this.studentservice = studentservice;
    }

    @PostMapping("addMarks")
    public Marks AddStudent(@RequestBody Marks m){
        return this.service.saveMarks(m);
    }
    @GetMapping("allmarks")
    public List<Marks> getAllMarks() {
        return this.service.getMarksList();
    }

    @DeleteMapping("deletemarks/{rid}")
    public void delete(@PathVariable Long rid) {
        service.deletemarks(rid);
    }
    @GetMapping("marks/{id}")
    public List<Marks> getStudentMarks(@PathVariable Long id) {
        Students s=studentservice.getStudantdata(id);

        return this.service.getStudentMarks(s);
    }
    @PutMapping("/marksupdate/{rid}")
    public ResponseEntity<?> update(@RequestBody Marks m, @PathVariable Long rid) {
        try {
            Marks o = service.get(rid);
            o.setId(m.getId());
            o.setMaths(m.getMaths());
            o.setHistory(m.getHistory());
            o.setScience(m.getScience());
            o.setSinhala(m.getSinhala());
            o.setEngish(m.getEngish());
            service.saveMarks(o);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
