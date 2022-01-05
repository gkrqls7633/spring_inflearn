package com.example.hello.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hello.hellospring.repository.JpaMemberRepository;
import com.example.hello.hellospring.repository.MemberRepository;
import com.example.hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
	
	@Autowired DataSource dataSource;
	
	private EntityManager em;
	
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}
	
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	

	@Bean
	public MemberRepository memberRepository() {
	//	return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(em);
	}
}
