package com.creativity.myblog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// spring
// 스프링이 com.creativity.myblog 패키지 이하를 스캔해서 모든 파일을 메모리에 new 하는 것은 아니구요.
// 특정 어노테이션이 붙어있는 클래스 파일들을 new해서 (IoC) 스프링 컨테니어네 관리해줍니다.
@RestController
public class BlogControllerTest {

	// https://localhost:8080/test/hello
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello spring boot</h1>";
	}
	
}
