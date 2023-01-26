package com.example.assignment;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.assignment.model.Students;
import com.example.assignment.repository.StudentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

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
}
