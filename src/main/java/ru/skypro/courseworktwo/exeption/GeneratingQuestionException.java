package ru.skypro.courseworktwo.exeption;

public class GeneratingQuestionException extends RuntimeException {

    public GeneratingQuestionException() {
        super("Generating question is fail!");
    }
}
