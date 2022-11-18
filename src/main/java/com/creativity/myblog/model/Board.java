package com.creativity.myblog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터를 처리할 때, 사용되는 데이터 타입
	private String content; // summernote라는 library를 사용 : <html>태그가 섞여서 디자인이 됨.
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	// Database의 연관관계도 설정이 가능함
	@ManyToOne // Many = Board, User = One (1명의  user는 여러개의 게시글을 쓸 수 있다는 의미)
	@JoinColumn(name="userId") // 테이블값은 userId로 만들어지고, 연관관계는 ManyToOne으로 만들어짐
	private User user;
	// DB는 오브젝트를 저장할 수 없다.
	// FK, 자바는 오브젝트를 저장할 수 있다.
	// JPA, ORM을 사용하면 오브젝트를 그대로 저장할 수  있다.
	// JPA는 User + Board를 join한 select문을 호출 (Board만 호출하면 User정보를 같이 줌)
	
	// User + Board + Reply
	// mappedBy가 있으면 연관관계의 주인이 아니다 (난 FK가 아니에요)
	// DB에 컬럼을 만들지 마세요
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Reply> replay; // 댓글정보는 하나만 가져오면 안되서 List 객체를 사용
	
	@CreationTimestamp // 데이터가 insert 혹은 update 될 때, 시간이 자동으로 입력
	private Timestamp createDate;
	
	// @ManyToMany
	/* ManyToMany는 사용하지 않는다.
	그 이유는 서로의 primary key로만 중간 테이블을 생성해주는데,
	날짜나 시간 다른 필드들이 필요할 수 있기 때문에, 내가 중간 테이블을 직접만들고
	@OneToMany, @OneToMany를 사용한다.
	*/
}
