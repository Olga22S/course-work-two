package ru.skypro.courseworktwo.service;

import ru.skypro.courseworktwo.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
