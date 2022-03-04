package ru.skypro.courseworktwo.exeption;

public class AlreadyExistQuestionException extends RuntimeException {

    public AlreadyExistQuestionException() {
        super("This question already exists!");
    }
}
