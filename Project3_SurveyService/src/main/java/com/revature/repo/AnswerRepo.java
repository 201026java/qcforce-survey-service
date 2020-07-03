package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entity.Answer;

@Repository
@Transactional
public interface AnswerRepo extends JpaRepository<Answer, Integer> {

}
