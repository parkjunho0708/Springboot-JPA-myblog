package com.creativity.myblog.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creativity.myblog.model.User;

@RestController
public class DummyControllerTest {

	// https://localhost:8080/blog/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	// x-www-form-urlencoded
	@PostMapping("/dummny/join")
	public String join(User user) { // key=value (약속된 규칙)
		System.out.println("id : " + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("create date : " + user.getCreateDate());
		return "회원가입이 완료되었습니다.";
	}
}
