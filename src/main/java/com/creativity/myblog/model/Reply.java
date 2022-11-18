package com.creativity.myblog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySQL에 자동으로 테이블을 생성해줌
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	// Database의 연관관계도 설정이 가능함
	@ManyToOne  // EAGER 무조건 들고와라
	@JoinColumn(name="boardId") // 테이블값은 userId로 만들어지고, 연관관계는 ManyToOne으로 만들어짐
	private Board board;
	
	@ManyToOne // EAGER 무조건 들고와라
	@JoinColumn(name="userId") // 테이블값은 userId로 만들어지고, 연관관계는 ManyToOne으로 만들어짐
	private User user;
	
	@CreationTimestamp // 데이터가 insert 혹은 update 될 때, 시간이 자동으로 입력
	private Timestamp createDate;
}
