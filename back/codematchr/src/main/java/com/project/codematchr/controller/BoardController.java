package com.project.codematchr.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.codematchr.dto.request.PatchBoardRequestDto;
import com.project.codematchr.dto.request.PostBoardRequestDto;
import com.project.codematchr.dto.response.DeleteBoardResponseDto;
import com.project.codematchr.dto.response.GetBoardResponseDto;
import com.project.codematchr.dto.response.GetTop3CommentListResponseDto;
import com.project.codematchr.dto.response.GetTop3CurrentListResponseDto;
import com.project.codematchr.dto.response.GetTop3FavoriteListResponseDto;
import com.project.codematchr.dto.response.GetUserListResponseDto;
import com.project.codematchr.dto.response.PatchBoardResponseDto;
import com.project.codematchr.dto.response.PostBoardResponseDto;
import com.project.codematchr.service.BoardService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;

    // API : 게시물 작성 메서드 //
    // ! 작성 다시 보기!!!!!!!!!!!//
    @PostMapping("/")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
        @RequestBody @Valid PostBoardRequestDto requestBody
    ){
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody);
        return response;
    }

    // API : 게시물 수정 메서드 //
    // todo :  이메일 받아오기 //
    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
        @PathVariable Integer boardNumber, 
        @RequestBody @Valid PatchBoardRequestDto dto
        ){
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(boardNumber, dto);
        return response;
    }

    // API : 게시물 삭제 메서드 //
    // todo :  이메일 받아오기 //
    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
        @PathVariable Integer boardNumber
    ){
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber);
        return response;
    }

    // API : 게시물 조회 메서드 //
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
        @PathVariable() Integer boardNumber
    ){
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    // API : 댓글 작성 메서드 //
    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<?> postComment(){
        return null;
    }

    // API : 좋아요 기능 메서드 //
    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<?> putFavorite(){
        return null;
    }

    // API : 특정 유저의 게시물 리스트 조회 메서드 //
    @GetMapping("/user-board-list/{writerEmail}")
    public ResponseEntity<? super GetUserListResponseDto> getUserBoardList(
        @PathVariable String writerEmail
        ){
        ResponseEntity<? super GetUserListResponseDto> response = boardService.getUserBoardList(writerEmail);
        return response;
    }

    // API : 특정 게시물의 댓글 리스트 조회 메서드 //
    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<?> getCommentList(){
        return null;
    }

    // API : 특정 게시물의 좋아요 리스트 조회 메서드 //
    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<?> getFavoriteList(){
        return null;
    }
    
    // API : 검색 게시물 리스트 조회 메서드 //
    //? 게시물 검색 시 searchWord가 우리는 boardTitle, boardContents 에서 검색어를 가져와야함 //
    @GetMapping("/search/{searchWord}")
    public ResponseEntity<?> getSearchBoard(){
        return null;
    }
    
    // API : TOP3 게시물 최신순 리스트 조회 메서드 //
    //? Mapping 주소 다시 확인하고 정리해야함 //
    @GetMapping("/top-3/current")
    public ResponseEntity<? super GetTop3CurrentListResponseDto> getTop3Current(){
        ResponseEntity<? super GetTop3CurrentListResponseDto> response = boardService.getTop3Current();
        return response;
    }

    // API : TOP3 게시물 댓글순 리스트 조회 메서드 //
    //? Mapping 주소 다시 확인하고 정리해야함 //
    @GetMapping("/top-3/comment")
    public ResponseEntity<? super GetTop3CommentListResponseDto> getTop3Comment(){
        ResponseEntity<? super GetTop3CommentListResponseDto> response = boardService.getTop3Comment();
        return response;
    }

    // API : TOP3 게시물 좋아요순 리스트 조회 메서드 //
    //? Mapping 주소 다시 확인하고 정리해야함 //
    @GetMapping("/top-3/favorite")
    public ResponseEntity<? super GetTop3FavoriteListResponseDto> getTop3Favorite(){
        ResponseEntity<? super GetTop3FavoriteListResponseDto> response = boardService.getTop3Favorite();
        return response;
    }
    

}

