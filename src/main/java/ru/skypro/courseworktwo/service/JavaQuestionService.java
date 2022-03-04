package ru.skypro.courseworktwo.service;

import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.exeption.AlreadyExistQuestionException;
import ru.skypro.courseworktwo.exeption.GeneratingQuestionException;
import ru.skypro.courseworktwo.exeption.NotFoundQuestionException;
import ru.skypro.courseworktwo.model.Question;

import java.util.*;

import static java.util.Objects.isNull;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
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
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int i = new Random().nextInt(questions.size());
        Question returnedQuestion = null;
        Iterator<Question> iterator = questions.iterator();
        while (i-- >= 0) {
            returnedQuestion = iterator.next();
        }
        if (!isNull(returnedQuestion)) {
            return returnedQuestion;
        }
        throw new GeneratingQuestionException();
    }
}
