package ru.skypro.courseworktwo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.courseworktwo.exeption.AmountQuestionException;
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
        if (javaQuestionService.getAll().size() + mathQuestionService.getAll().size() < amount) {
            throw new AmountQuestionException();
        }
        generateJavaQuestions(amount, questions);
        generateMathQuestions(amount, questions);
//        while (amount-- > 0) {
//            if (!questions.add(questionService.getRandomQuestion())) {
//                amount++;
//            }
//        }
        return questions;
    }

    private void generateJavaQuestions(int totalAmount, Collection<Question> questions){
        int questionsNum = getJavaQuestionsNumber(totalAmount);

    }

    private void generateMathQuestions(int totalAmount, Collection<Question> questions){

    }

    private int getJavaQuestionsNumber(int totalAmount){
        return new Random().nextInt(javaQuestionService.getAll().size());
    }
}
