package ru.skypro.courseworktwo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.exeption.GeneratingQuestionException;
import ru.skypro.courseworktwo.model.Question;
import ru.skypro.courseworktwo.repository.QuestionRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import static java.util.Objects.isNull;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Logger logger = LoggerFactory.getLogger(JavaQuestionService.class);

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return questionRepository.add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        logger.info("Add java question= " + question);
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        logger.info("Remove java question= " + question);
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        logger.info("Getting all java questions.");
        return Collections.unmodifiableCollection(questionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        logger.info("Generating random java question...");
        int i = new Random().nextInt(questionRepository.getAll().size());
        Question returnedQuestion = null;
        Iterator<Question> iterator = questionRepository.getAll().iterator();
        while (i-- >= 0) {
            returnedQuestion = iterator.next();
        }
        if (!isNull(returnedQuestion)) {
            return returnedQuestion;
        }
        throw new GeneratingQuestionException();
    }
}
