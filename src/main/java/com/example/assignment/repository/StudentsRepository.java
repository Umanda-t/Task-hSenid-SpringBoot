package com.example.assignment.repository;

import com.example.assignment.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    @Query("SELECT s.name FROM Students s WHERE s.id=:id")
    public String findStudentname(Long id);
}
