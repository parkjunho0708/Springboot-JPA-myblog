package com.creativity.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creativity.myblog.model.User;

// jsp로 치면 DAO로 생각하면 됨.
// 자동으로 bean으로 등록이 됨.
// @Repository 어노테이션이 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	// findAll() : User 테이블이 들고 있는 모든 행을 모두 return
	// findById() : Id로 행을 찾아내는 메소드
}
