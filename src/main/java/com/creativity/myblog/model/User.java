package com.creativity.myblog.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술

@Data // getter, setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySQL에 자동으로 테이블을 생성해줌
// @DynamicInsert // insert할 때, null인 field를 제외시켜주는 어노테이션
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id; // sequence, auto_increment ID는 비워놔도 자동으로 들어감
	
	@Column(nullable = false, length = 30)
	private String username; // id
	
	@Column(nullable = false, length = 100) // 123456 => 해쉬 (비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	// 정확하게 하려면 Enum을 쓰는게 좋다
	// admin, user, manager
	// DB는 RoleType이라는 것이 없음
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp // 시간이 자동으로 입력
	private Timestamp createDate; // Java에서 현재 시간을 넣어서 insert
}
