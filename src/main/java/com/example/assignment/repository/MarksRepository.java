package com.example.assignment.repository;
import com.example.assignment.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepository extends JpaRepository<Marks, Long> {
}
