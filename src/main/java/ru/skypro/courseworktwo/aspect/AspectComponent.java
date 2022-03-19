package ru.skypro.courseworktwo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.skypro.courseworktwo.service.JavaQuestionService;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class AspectComponent {

    private final Logger logger = LoggerFactory.getLogger(JavaQuestionService.class);

   // @Around("execution(public * ru.skypro.courseworktwo.controller.JavaQuestionController.*(..))")
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("Args " + joinPoint + ", args= " + "[" + args + "]");
        return proceed;
    }
}
