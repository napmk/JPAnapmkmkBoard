package com.napmkmk.mkboard.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.napmkmk.mkboard.entity.Question;
import com.napmkmk.mkboard.repository.QuestionRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class QuestionTest {

		@Autowired
		private QuestionRepository questionRepository;
		
		@Test
		@DisplayName("질문저장 테스트")
		public void testQuestion1() {
			Question q1 = new Question();//빈 Question 객체
			q1.setSubject("되냐??!!!");
			q1.setContent("정말 잘 나옵니까?");
			q1.setCreateDate(LocalDateTime.now());//현재시간저장
			//속성값이 초기화 된 Question 객체q1이 만들어짐
			questionRepository.save(q1); //첫번째 질문 생성 저장
			
			Question q2= new Question();//빈 Question 객체
			q2.setSubject("질문있어요");
			q2.setContent("정말 취업이 될까요?");
			q2.setCreateDate(LocalDateTime.now());//현재시간저장
			//속성값이 초기화 된 Question 객체q2이 만들어짐
			questionRepository.save(q2); //두번째 질문 생성 저장
		}
		@Test
		@DisplayName("조회테스트")
		public void testQuestion2() {
			List<Question> qAll = questionRepository.findAll();// 질문게시판의 모든 글  가져오기
			assertEquals(2,qAll.size());//전체글의 개수를 가져와 기대하고 있는 글의 개수인 2와 비교 확인
			
			Question q1 = qAll.get(0);//첫번째 글 가져오기
			assertEquals("되냐??!!!",q1.getSubject());
			
			Optional<Question> q2 = questionRepository.findById(2);//2번글 가져오기 Optional로 타입을 바꿔야함 없을수도 있으니까
			Optional<Question> q3 = questionRepository.findById(3);//3번글 가져오기 Optional로 타입을 바꿔야함 없을수도 있으니까
			
			if(q2.isPresent()) {
				System.out.println("q2 내용있음");
			}
			
			if(q3.isEmpty()) {
				System.out.println("q3 내용있음");
			}
		}
		
		
}
