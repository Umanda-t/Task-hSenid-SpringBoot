package com.example.assignment;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.assignment.model.Students;
import com.example.assignment.repository.StudentsRepository;
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
public class StudentsRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentsRepository repo;
    @Test
    public void testAddStudents() {
        Students o= new Students();
        o.setName("M.K. Mayuni");
        o.setGrade("Grade10");
        Students s=repo.save(o);

        Students exist = entityManager.find(Students.class, s.getId());

        assertThat(o.getName()).isEqualTo(exist.getName());
    }


    @Test
    public void testGetID()
    {
        Long id= Long.valueOf(12);
        Optional<Students> o= repo.findById(id);
        Assertions.assertThat(o).isPresent();

    }
    @Test
    public void testGetNamebyID()
    {
        Long id= Long.valueOf(9);
        String o= repo.findStudentname(id);
        Assertions.assertThat(o).isEqualTo("K.J. Ashini");

    }

    @Test
    public void testDelete()
    {
        Long id= Long.valueOf(6);
        repo.deleteById(id);
        Optional<Students> o= repo.findById(id);
        Assertions.assertThat(o).isNotPresent();


    }
}
