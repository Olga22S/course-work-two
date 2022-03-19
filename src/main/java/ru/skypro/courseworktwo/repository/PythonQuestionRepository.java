package ru.skypro.courseworktwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.courseworktwo.model.PythonQuestion;

@Repository
public interface PythonQuestionRepository extends JpaRepository<PythonQuestion, Long> {

}
