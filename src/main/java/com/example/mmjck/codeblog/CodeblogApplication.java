package com.example.mmjck.codeblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mmjck.codeblog.repository.CodeblogRepository;

@SpringBootApplication
public class CodeblogApplication {
	public static void main(String[] args) {
		SpringApplication.run(CodeblogApplication.class, args);

		
	}

}
