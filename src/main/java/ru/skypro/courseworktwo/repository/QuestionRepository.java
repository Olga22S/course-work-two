package ru.skypro.courseworktwo.repository;

import ru.skypro.courseworktwo.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
