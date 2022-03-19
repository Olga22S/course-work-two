package ru.skypro.courseworktwo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.model.PythonQuestion;
import ru.skypro.courseworktwo.repository.PythonQuestionRepository;

import java.util.Collection;

@Service
public class PythonQuestionServiceImpl implements PythonQuestionService {

    private final Logger logger = LoggerFactory.getLogger(PythonQuestionServiceImpl.class);
    private final PythonQuestionRepository repository;

    public PythonQuestionServiceImpl(PythonQuestionRepository pythonQuestionRepository) {
        this.repository = pythonQuestionRepository;
    }

    @Override
    public PythonQuestion add(String question, String answer) {
        PythonQuestion pythonQuestion = new PythonQuestion(question, answer);
        return add(pythonQuestion);
    }

    @Override
    public PythonQuestion add(PythonQuestion question) {
        logger.info("Add python question= " + question);
        return repository.save(question);
    }

    @Override
    public PythonQuestion remove(PythonQuestion question) {
        logger.info("Remove python question= " + question);
        repository.delete(question);
        return question;
    }

    @Override
    public Collection<PythonQuestion> getAll() {
        logger.info("Getting all python questions.");
        return repository.findAll();
    }
}
