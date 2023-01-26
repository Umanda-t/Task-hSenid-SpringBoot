package com.example.assignment.service;

import com.example.assignment.model.Students;
import com.example.assignment.repository.StudentsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentsService {

    @Autowired
    private StudentsRepository Repo;
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
}
