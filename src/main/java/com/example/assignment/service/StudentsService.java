package com.example.assignment.service;

import com.example.assignment.model.Students;
import com.example.assignment.repository.StudentsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {


    private StudentsRepository Repo;

    public StudentsService(StudentsRepository repo) {
        Repo = repo;
    }

    public List<Students> getStudentsList() {

        return this.Repo.findAll();
    }
    public Students saveStudent(Students s){
        return Repo.save(s);
    }

    public void deleteStudent(Long id) {
        Repo.deleteById(id);
    }

    public String getStudentName(Long id) {
        return Repo.findStudentname(id);
    }

    public Students getStudantdata(Long id){
        return Repo.findStudent(id);
    }

    public Students get(Long id) {
        return Repo.findById(id).get();
    }
}
