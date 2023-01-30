package com.example.assignment.service;

import com.example.assignment.model.Marks;
import com.example.assignment.model.Students;
import com.example.assignment.repository.MarksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MarksService {
    private StudentsService studentservice;
    public MarksRepository Repo;

    public MarksService(StudentsService studentservice, MarksRepository repo) {
        this.studentservice = studentservice;
        Repo = repo;
    }

    public Marks saveMarks(Marks m){
        return Repo.save(m);
    }
    public List<Marks> getMarksList(){
        return this.Repo.findAll();
    }
    public void deletemarks(Long rid) {
        Repo.deleteById(rid);
    }
    public List<Marks> getStudentMarks(Long id){
        Students s=studentservice.getStudantdata(id);
        return this.Repo.findMarks(s);
    }

    public Marks get(Long rid) {
        return Repo.findById(rid).get();
    }
}
