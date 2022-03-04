package ru.skypro.courseworktwo.service;

import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.exeption.AmountQuestionException;
import ru.skypro.courseworktwo.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new AmountQuestionException();
        }
        while (amount-- > 0) {
            if (!questions.add(questionService.getRandomQuestion())) {
                amount++;
            }
        }
        return questions;
    }
}
