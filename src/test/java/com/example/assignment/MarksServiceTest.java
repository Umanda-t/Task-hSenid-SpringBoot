package com.example.assignment;

import com.example.assignment.model.Marks;
import com.example.assignment.model.Students;
import com.example.assignment.repository.MarksRepository;
import com.example.assignment.service.MarksService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MarksServiceTest {
    @InjectMocks
    private MarksService service;
    @Mock
    private MarksRepository repo;
    @Test
    public void testgetMarksList() {
        when(repo.findAll()).thenReturn(List.of(new Marks(), new Marks()));
        assertThat(service.getMarksList()).hasSize(2);

    }

//    @Test
//    public void testgetStudentMarks() {
//        Students s=new Students();
//        s.setId(14L);
//        s.setName("M.K. Mayuni");
//        s.setGrade("Grade10");
//        when(repo.findMarks(s)).thenReturn(List.of(new Marks(), new Marks(), new Marks()));
//        assertThat(service.getStudentMarks(s)).hasSize(3);
//    }

}
