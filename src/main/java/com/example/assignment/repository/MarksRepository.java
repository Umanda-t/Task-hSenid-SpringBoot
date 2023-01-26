package com.example.assignment.repository;
import com.example.assignment.model.Marks;
import com.example.assignment.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    @Query("SELECT s FROM Marks s WHERE s.id= ?1")
    public List<Marks> findMarks(Students id);
}
