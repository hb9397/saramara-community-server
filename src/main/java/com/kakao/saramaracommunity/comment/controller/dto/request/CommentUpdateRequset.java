package com.kakao.saramaracommunity.comment.controller.dto.request;

import com.kakao.saramaracommunity.comment.service.dto.request.CommentCreateServiceRequest;
import com.kakao.saramaracommunity.comment.service.dto.request.CommentUpdateServiceRequset;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentUpdateRequset {

    private Long commentId;

    @NotNull(message = "회원정보은 필수입니다.")
    private Long memberId;

    @NotNull(message = "게시글 번호는 필수입니다.")
    private Long boardId;

    @NotBlank(message = "댓글 내용은 필수입니다.")
    private String content;

    @NotNull(message = "투표를 선택해주세요.")
    private Long pick;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    @Builder
    private CommentUpdateRequset(Long commentId, Long memberId, Long boardId, String content, Long pick, LocalDateTime regDate, LocalDateTime modDate) {
        this.commentId = commentId;
        this.memberId = memberId;
        this.boardId = boardId;
        this.content = content;
        this.pick = pick;
        this.regDate = regDate;
        this.modDate = modDate;
    }

    public CommentUpdateServiceRequset toServiceRequest() {
        return CommentUpdateServiceRequset.builder()
                .commentId(commentId)
                .memberId(memberId)
                .boardId(boardId)
                .content(content)
                .pick(pick)
                .regDate(regDate)
                .modDate(modDate)
                .build();
    }
}
