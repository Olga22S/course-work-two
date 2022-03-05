package ru.skypro.courseworktwo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skypro.courseworktwo.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void initMock() {
        when(questionService.getRandomQuestion())
                .thenReturn(new Question("Question1", "Answer1"));
        when(questionService.getAll())
                .thenReturn(getQuestionServiceGetAll());
     

    }

    @Test
    void getQuestions() {
        Collection<Question> expected = getExpectedQuestions();

        Collection<Question> result = examinerService.getQuestions(1);

        assertTrue(result.containsAll(expected));
    }

    private Collection<Question> getExpectedQuestions(){
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Question1", "Answer1"));
        return questions;
    }

    private Collection<Question> getQuestionServiceGetAll(){
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Question1", "Answer1"));
        questions.add(new Question("Question2", "Answer2"));
        return questions;
    }
}