package com.example.assignment;


import com.example.assignment.model.Marks;
import com.example.assignment.model.Students;
import com.example.assignment.repository.MarksRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MarksRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MarksRepository repo;
    @Test
    public void testAddMarks() {
        Students studentid=entityManager.find(Students.class,12);
        Marks o= new Marks();
        o.setId(studentid);
        o.setMaths(67);
        o.setEngish(78);
        o.setHistory(88);
        o.setScience(56);
        o.setSinhala(81);

        repo.save(o);
    }
    @Test
    public void testDelete()
    {
        Long id= Long.valueOf(3);
        repo.deleteById(id);
        Optional<Marks> o= repo.findById(id);
        Assertions.assertThat(o).isNotPresent();


    }
    @Test
    public void getID()
    {
        Long id= Long.valueOf(1);
        Optional<Marks> o= repo.findById(id);
        Assertions.assertThat(o).isPresent();


    }

}
