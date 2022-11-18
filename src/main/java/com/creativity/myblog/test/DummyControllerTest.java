package com.creativity.myblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creativity.myblog.model.RoleType;
import com.creativity.myblog.model.User;
import com.creativity.myblog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	// DummyControllerTest 메모리에 뜰 때, UserRepository도 메모리에 같이 뜸
	// 의존성 주입
	@Autowired
	private UserRepository userRepository;

	// https://localhost:8080/blog/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	// x-www-form-urlencoded
	@PostMapping("/dummny/join")
	public String join(User user) { // key=value (약속된 규칙)
		System.out.println("id : " + user.getId()); // auto increment로 데이터가 들어가 있게 되어있음
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("create date : " + user.getCreateDate()); // java에서 만들어서 insert
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}
