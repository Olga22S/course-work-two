package ru.skypro.courseworktwo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.courseworktwo.aspect.LogExecutionTime;
import ru.skypro.courseworktwo.model.Question;
import ru.skypro.courseworktwo.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @LogExecutionTime
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @LogExecutionTime
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @LogExecutionTime
    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
