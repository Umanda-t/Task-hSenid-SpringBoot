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
    public ResponseEntity<Marks> AddStudent(@RequestBody Marks m){
        Marks o=service.saveMarks(m);
        return ResponseEntity.ok().body(o);
    }
    @GetMapping("allmarks")
    public ResponseEntity<List<Marks>> getAllMarks() {
        List<Marks> o=service.getMarksList();
        return ResponseEntity.ok().body(o);
    }

    @DeleteMapping("deletemarks/{rid}")
    public void delete(@PathVariable Long rid) {
        service.deletemarks(rid);
    }
    @GetMapping("marks/{id}")
    public ResponseEntity<List<Marks>> getStudentMarks(@PathVariable Long id) {
      //  Students s=studentservice.getStudantdata(id);

        List<Marks> o=service.getStudentMarks(id);
        return ResponseEntity.ok().body(o);
    }
    @PutMapping("/marksupdate/{rid}")
    public ResponseEntity<String> update(@RequestBody Marks m, @PathVariable Long rid) {
        try {
            Marks o = service.get(rid);
            o.setId(m.getId());
            o.setMaths(m.getMaths());
            o.setHistory(m.getHistory());
            o.setScience(m.getScience());
            o.setSinhala(m.getSinhala());
            o.setEngish(m.getEngish());
            service.saveMarks(o);
            return ResponseEntity.ok("Success");
        } catch (NoSuchElementException e) {
            return ResponseEntity.ok("Fail");
        }
    }
}
