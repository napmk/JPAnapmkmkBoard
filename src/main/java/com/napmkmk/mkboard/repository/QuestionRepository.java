package com.napmkmk.mkboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.napmkmk.mkboard.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
