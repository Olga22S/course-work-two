package ru.skypro.courseworktwo.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.courseworktwo.exeption.AlreadyExistQuestionException;
import ru.skypro.courseworktwo.exeption.NotFoundQuestionException;
import ru.skypro.courseworktwo.model.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private Collection<Question> questions = new HashSet<>();

    public MathQuestionRepository() {
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new AlreadyExistQuestionException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new NotFoundQuestionException();
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("2 + 2 = ", "4"));
        questions.add(new Question("100 * 10 = ", "1000"));
        questions.add(new Question("2 / 0 = ", "error"));
        questions.add(new Question("ln10 = ", "not answer"));
        questions.add(new Question("pi = ", "3,14"));
    }
}
