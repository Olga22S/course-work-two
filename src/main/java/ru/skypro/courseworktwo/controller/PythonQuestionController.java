package ru.skypro.courseworktwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.courseworktwo.aspect.LogExecutionTime;
import ru.skypro.courseworktwo.model.PythonQuestion;
import ru.skypro.courseworktwo.service.PythonQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam/python")
public class PythonQuestionController {

    private final PythonQuestionServiceImpl questionService;

    public PythonQuestionController(PythonQuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @LogExecutionTime
    @GetMapping("/add")
    public PythonQuestion addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @LogExecutionTime
    @GetMapping("/remove")
    public PythonQuestion removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new PythonQuestion(question, answer));
    }

    @LogExecutionTime
    @GetMapping()
    public Collection<PythonQuestion> getAll() {
        return questionService.getAll();
    }
}
