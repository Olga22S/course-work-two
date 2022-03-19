package ru.skypro.courseworktwo.service;

import ru.skypro.courseworktwo.model.PythonQuestion;

import java.util.Collection;

public interface PythonQuestionService {

    PythonQuestion add(String question, String answer);

    PythonQuestion add(PythonQuestion question);

    PythonQuestion remove(PythonQuestion question);

    Collection<PythonQuestion> getAll();
}
