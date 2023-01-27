package com.example.assignment;

import com.example.assignment.model.Students;
import com.example.assignment.repository.StudentsRepository;
import com.example.assignment.service.StudentsService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public final class StudentsServiceTest {
    @InjectMocks
    private StudentsService service;
    @Mock
    private StudentsRepository repo;

    @Test
    public void testgetStudentsList() {
        when(repo.findAll()).thenReturn(List.of(new Students(), new Students(),new Students()));
        assertThat(service.getStudentsList()).hasSize(3);

    }

    @Test
    public void testgetStudentName() {
        Long id= Long.valueOf(16);
        when(repo.findStudentname(id)).thenReturn("K.J. Kamala");
        assertThat(service.getStudentName(id)).isEqualTo("K.J. Kamala");
    }



}
