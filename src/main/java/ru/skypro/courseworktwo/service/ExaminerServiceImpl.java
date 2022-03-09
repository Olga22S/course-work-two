package ru.skypro.courseworktwo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private List<QuestionService> services = new ArrayList<>();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        services.add(javaQuestionService);
        services.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        generateJavaQuestions(amount, questions);
        generateMathQuestions(amount, questions);
        return questions;
    }

    private void generateJavaQuestions(int totalAmount, Collection<Question> questions){
        int questionsNum = getJavaQuestionsNumber(totalAmount);
        while (questionsNum-- > 0) {
            if (!questions.add(services.get(0).getRandomQuestion())) {
                questionsNum++;
            }
        }
    }

    private void generateMathQuestions(int totalAmount, Collection<Question> questions){
        int questionsNum = totalAmount - questions.size();
        while (questionsNum-- > 0) {
            if (!questions.add(services.get(1).getRandomQuestion())) {
                questionsNum++;
            }
        }
    }

    private int getJavaQuestionsNumber(int totalAmount) {
        int questionsNum = new Random().nextInt(totalAmount + 1);
        int javaQuestionsTotal = services.get(0).getAll().size();
        if (questionsNum > javaQuestionsTotal) {
            questionsNum = javaQuestionsTotal;
        }
        return questionsNum;
    }
}
