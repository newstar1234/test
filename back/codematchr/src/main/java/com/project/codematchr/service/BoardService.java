package com.project.codematchr.service;

import org.springframework.http.ResponseEntity;

import com.project.codematchr.dto.request.PostBoardRequestDto;
import com.project.codematchr.dto.response.GetBoardResponseDto;
import com.project.codematchr.dto.response.PostBoardResponseDto;


public interface BoardService {
    
    // method : 게시물 작성 메서드 //
    ResponseEntity<? super PostBoardResponseDto> postBoard();
    // method : 게시물 수정 메서드 //
    ResponseEntity<?> patchBoard();
    // method : 게시물 삭제 메서드 //
    ResponseEntity<?> deleteBoard();
    // method : 게시물 조회 메서드 //
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    

}