package ru.skypro.courseworktwo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountQuestionException extends RuntimeException {

    public AmountQuestionException() {
        super("There are not enough questions in storage!");
    }
}
