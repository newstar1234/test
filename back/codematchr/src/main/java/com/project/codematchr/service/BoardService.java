package com.project.codematchr.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.project.codematchr.dto.request.PatchBoardRequestDto;
import com.project.codematchr.dto.request.PostBoardRequestDto;
import com.project.codematchr.dto.response.DeleteBoardResponseDto;
import com.project.codematchr.dto.response.GetBoardResponseDto;
import com.project.codematchr.dto.response.GetCommentListResponseDto;
import com.project.codematchr.dto.response.GetTop3CommentListResponseDto;
import com.project.codematchr.dto.response.GetTop3CurrentListResponseDto;
import com.project.codematchr.dto.response.GetTop3FavoriteListResponseDto;
import com.project.codematchr.dto.response.GetUserListResponseDto;
import com.project.codematchr.dto.response.PatchBoardResponseDto;
import com.project.codematchr.dto.response.PostBoardResponseDto;


public interface BoardService {
    
    // method : 게시물 작성 메서드 //
    // ? //
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto);
    // method : 게시물 수정 메서드 //
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(Integer boardNumber, PatchBoardRequestDto dto);
    // method : 게시물 삭제 메서드 //
    // ? //
    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber);
    // method : 게시물 조회 메서드 //
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    
    // method : TOP3 게시물 최신순 조회 메서드 //
    ResponseEntity<? super GetTop3CurrentListResponseDto> getTop3Current();
    // method : TOP3 게시물 댓글순 조회 메서드 //
    ResponseEntity<? super GetTop3CommentListResponseDto> getTop3Comment();
    // method : TOP3 게시물 좋아요순 조회 메서드 //
    ResponseEntity<? super GetTop3FavoriteListResponseDto> getTop3Favorite();

    // method : 댓글 작성 메서드 //
    ResponseEntity<?> postComment();
    // method : 좋아요 기능 메서드 //
    ResponseEntity<?> putFavorite();
    // method : 특정 유저의 게시물 리스트 조회 메서드 //
    ResponseEntity<? super GetUserListResponseDto> getUserBoardList(String writerEmail);
    // method : 특정 게시물의 댓글 리스트 조회 메서드 //
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer commentBoardNumber);
    // method : 특정 게시물의 좋아요 리스트 조회 메서드 //
    ResponseEntity<?> getFavoriteList();
    // method : 검색 게시물 리스트 조회 메서드 //
    ResponseEntity<?> getSearchBoard();

}
