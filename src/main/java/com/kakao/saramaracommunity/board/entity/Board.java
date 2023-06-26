package com.kakao.saramaracommunity.board.entity;

import com.kakao.saramaracommunity.common.entity.BaseTimeEntity;
import com.kakao.saramaracommunity.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Where(clause = "deleted_at is NULL")
@SQLDelete(sql = "update board set deleted_at = CURRENT_TIMESTAMP where board_id = ?")
@ToString(exclude = {"member", "category"})
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId; // 게시글 고유 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberId")
    private Member member; // 게시글 작성자

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category; // 카테고리 (NORMAL, QUESTION ... DEFAULT: NORMAL)

    @Column(length = 100, nullable = false)
    private String title; // 게시글 제목

    @Lob
    private String content; // 게시글 내용

    @Column(columnDefinition = "integer default 0", nullable = false)	// 조회수의 기본 값을 0으로 지정, null 불가 처리
    private Long boardCnt; // 게시글 조회수

    @Column(columnDefinition = "integer default 0", nullable = false)	// 조회수의 기본 값을 0으로 지정, null 불가 처리
    private Long likeCnt; // 게시글 좋아요 수

    private LocalDateTime deadLine;

    @Builder
    public Board(
        Long boardId, Member member, Category category, String title,
        String content, Long boardCnt, Long likeCnt, LocalDateTime deadLine) {

        this.boardId = boardId;
        this.member = member;
        this.category = category;
        this.title = title;
        this.content = content;
        this.boardCnt = boardCnt;
        this.likeCnt = likeCnt;
        this.deadLine = deadLine;
    }

    @PrePersist
    public void prePersist() {

        this.boardCnt = this.boardCnt == null ? 0 : this.boardCnt;
        this.likeCnt = this.likeCnt == null ? 0 : this.likeCnt;
    }
}