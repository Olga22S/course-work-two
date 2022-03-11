package ru.skypro.courseworktwo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private List<QuestionService> services = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(JavaQuestionService.class);

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        services.add(javaQuestionService);
        services.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        logger.info("Generating list of all subjects questions...");
        Set<Question> questions = new HashSet<>();
        generateJavaQuestions(amount, questions);
        generateMathQuestions(amount, questions);
        logger.info("List of questions was successfully generated!");
        return questions;
    }

    private void generateJavaQuestions(int totalAmount, Collection<Question> questions){
        logger.info("Generating list of java questions...");
        int questionsNum = getJavaQuestionsNumber(totalAmount);
        while (questionsNum-- > 0) {
            if (!questions.add(services.get(0).getRandomQuestion())) {
                questionsNum++;
            }
        }
    }

    private void generateMathQuestions(int totalAmount, Collection<Question> questions){
        logger.info("Generating list of math questions...");
        int questionsNum = totalAmount - questions.size();
        while (questionsNum-- > 0) {
            if (!questions.add(services.get(1).getRandomQuestion())) {
                questionsNum++;
            }
        }
    }

    private int getJavaQuestionsNumber(int totalAmount) {
        logger.info("Generating number of java questions...");
        int questionsNum = new Random().nextInt(totalAmount + 1);
        int javaQuestionsTotal = services.get(0).getAll().size();
        if (questionsNum > javaQuestionsTotal) {
            questionsNum = javaQuestionsTotal;
        }
        return questionsNum;
    }
}
