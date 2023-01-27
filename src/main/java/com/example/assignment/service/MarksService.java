package com.example.assignment.service;

import com.example.assignment.model.Marks;
import com.example.assignment.model.Students;
import com.example.assignment.repository.MarksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class MarksService {
    @Autowired
    public MarksRepository Repo;

    public Marks saveMarks(Marks m){
        return Repo.save(m);
    }
    public List<Marks> getMarksList(){
        return this.Repo.findAll();
    }
    public void deletemarks(Long rid) {
        Repo.deleteById(rid);
    }
    public List<Marks> getStudentMarks(Students id){
        return this.Repo.findMarks(id);
    }

    public Marks get(Long rid) {
        return Repo.findById(rid).get();
    }
}
