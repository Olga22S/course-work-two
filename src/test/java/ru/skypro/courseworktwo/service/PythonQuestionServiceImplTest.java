package ru.skypro.courseworktwo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skypro.courseworktwo.model.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PythonQuestionServiceImplTest {

    private JavaQuestionService questionService;

//    @BeforeEach
//    void setUp() {
//        questionService = new JavaQuestionService(questionRepository);
//        questionService.add("Question 1", "Answer 1");
//        questionService.add("Question 2", "Answer 2");
//    }

    @Test
    void add() {
        assertEquals(questionService.getAll().size(), 2);
        questionService.add("Question 3", "Answer 3");
        assertEquals(questionService.getAll().size(), 3);
    }

    @Test
    void testAdd() {
        assertEquals(questionService.getAll().size(), 2);
        questionService.add(new Question("Question 3", "Answer 3"));
        assertEquals(questionService.getAll().size(), 3);
    }

    @Test
    void remove() {
        assertEquals(questionService.getAll().size(), 2);
        questionService.remove(new Question("Question 1", "Answer 1"));
        assertEquals(questionService.getAll().size(), 1);
    }

    @Test
    void getAll() {
        Collection<Question> expected = getExpectedQuestions();

        Collection<Question> result = questionService.getAll();

        assertTrue(result.containsAll(expected));
    }

    @Test
    void getRandomQuestion() {
        Question randomQuestion = questionService.getRandomQuestion();

        assertTrue(questionService.getAll().contains(randomQuestion));
    }

    private Collection<Question> getExpectedQuestions() {
        Collection<Question> questions = new HashSet<>();
        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));
        return Collections.unmodifiableCollection(questions);
    }
}