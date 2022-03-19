package ru.skypro.courseworktwo.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.courseworktwo.exeption.AlreadyExistQuestionException;
import ru.skypro.courseworktwo.exeption.NotFoundQuestionException;
import ru.skypro.courseworktwo.model.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private Set<Question> questions = new HashSet<>();

    public JavaQuestionRepository() {
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
    private void init(){
        questions.add(new Question("What is Spring?", "FrameWork"));
        questions.add(new Question("What is Map?", "Data structure"));
        questions.add(new Question("What is variable?", "Named memory area"));
        questions.add(new Question("What is encapsulation?", "Hiding the implementation"));
        questions.add(new Question("What is recurse?", "Droch"));
    }
}
