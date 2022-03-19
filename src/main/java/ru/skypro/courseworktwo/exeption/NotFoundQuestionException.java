package ru.skypro.courseworktwo.exeption;

public class NotFoundQuestionException extends RuntimeException {

    public NotFoundQuestionException() {
        super("Question is not found!");
    }
}
