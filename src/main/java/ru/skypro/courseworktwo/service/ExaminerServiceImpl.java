package ru.skypro.courseworktwo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService")QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
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
            if (!questions.add(javaQuestionService.getRandomQuestion())) {
                questionsNum++;
            }
        }
    }

    private void generateMathQuestions(int totalAmount, Collection<Question> questions){
        int questionsNum = totalAmount - questions.size();
        while (questionsNum-- > 0) {
            if (!questions.add(mathQuestionService.getRandomQuestion())) {
                questionsNum++;
            }
        }
    }

    private int getJavaQuestionsNumber(int totalAmount) {
        int questionsNum = new Random().nextInt(totalAmount + 1);
        int javaQuestionsTotal = javaQuestionService.getAll().size();
        if (questionsNum > javaQuestionsTotal) {
            questionsNum = javaQuestionsTotal;
        }
        return questionsNum;
    }
}
