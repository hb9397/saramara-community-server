package com.kakao.saramaracommunity.board.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;

import com.kakao.saramaracommunity.board.service.dto.request.BoardServiceRequestDto;
import com.kakao.saramaracommunity.board.service.dto.response.BoardResponseDto;
import com.kakao.saramaracommunity.board.entity.Board;
import com.kakao.saramaracommunity.board.util.CursorResult;

public interface BoardService {

    //게시글 등록 요청 Method
    Board saveBoard(BoardServiceRequestDto.SaveRequestDto requestDto);

    // boardId를 매개변수로 받아 해당 게시글을 조회하는 기능의 Method
    BoardResponseDto.ReadOneBoardResponseDto readOneBoard(Long boardId);

    // 게시글 전체를 최신순으로 조회하는 기능의 Method
    CursorResult<BoardResponseDto.ReadAllBoardResponseDto> readAllBoardsByLatest(Long cursorId, Pageable pageable);

    // 게시글 전체를 인기순으로 조회하는 기능의 Method
    CursorResult<BoardResponseDto.ReadAllBoardResponseDto> readAllBoardsByPopularity(Long cursorId, Pageable pageable);

    // 게시글 수정 요청 Method
    Boolean updateBoard(Long boardId, BoardServiceRequestDto.UpdateRequestDto requestDto);

    // 게시글 삭제 요청 Method
    Boolean deleteBoard(Long boardId);
}