package com.project.codematchr.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.codematchr.dto.ResponseDto;
import com.project.codematchr.dto.request.PatchBoardRequestDto;
import com.project.codematchr.dto.request.PostBoardRequestDto;
import com.project.codematchr.dto.response.BoardListResponseDto;
import com.project.codematchr.dto.response.CommentListResponseDto;
import com.project.codematchr.dto.response.DeleteBoardResponseDto;
import com.project.codematchr.dto.response.GetBoardResponseDto;
import com.project.codematchr.dto.response.GetCommentListResponseDto;
import com.project.codematchr.dto.response.GetTop3CommentListResponseDto;
import com.project.codematchr.dto.response.GetTop3CurrentListResponseDto;
import com.project.codematchr.dto.response.GetTop3FavoriteListResponseDto;
import com.project.codematchr.dto.response.GetUserListResponseDto;
import com.project.codematchr.dto.response.PatchBoardResponseDto;
import com.project.codematchr.dto.response.PostBoardResponseDto;
import com.project.codematchr.entity.BoardEntity;
import com.project.codematchr.entity.BoardViewEntity;
import com.project.codematchr.entity.resultSet.CommentListResultSet;
import com.project.codematchr.repository.BoardRepository;
import com.project.codematchr.repository.BoardViewRepository;
import com.project.codematchr.repository.CommentRepository;
import com.project.codematchr.repository.UserRepository;
import com.project.codematchr.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {
    
    private final BoardRepository boardRepository;
    private final BoardViewRepository boardViewRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

// description : 게시물 작성 //
@Override
public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto) {
    
    try {
        // todo : 작성자 이메일이 존재하는지 확인 //
        // boolean hasWriterEmail = userRepository.existsByUserEmail(boardWriterEmail);
        // if(!hasWriterEmail) return PostBoardResponseDto.noExistedUserEmail();
        
        // description : entity 생성 //
        BoardEntity boardEntity = new BoardEntity(dto);
        
        // description : 데이터 베이스에 저장 //
        boardRepository.save(boardEntity);
        System.out.println(boardEntity);
        
    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    
    return PostBoardResponseDto.success();
}

// description : 게시물 수정 //
@Override
public ResponseEntity<? super PatchBoardResponseDto> patchBoard(Integer boardNumber, PatchBoardRequestDto dto) {

    try {
        BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
        if(boardEntity == null) return null;

        boardEntity.patch(dto);
        boardRepository.save(boardEntity);

    } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
    }
    return PatchBoardResponseDto.success();
    
    
}

// description : 게시물 삭제 //
// ? //
@Override
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber) {

        try {
            // descriptiont: 존재하는 유저인지 확인 //
            // boolean hasWriterEmail = userRepository.existsByUserEmail(userEmail);
            // if(!hasWriterEmail) return DeleteBoardResponseDto.noExistedUserEmail();
            // description : 존재하는 게시물인지 확인 //
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return DeleteBoardResponseDto.noExistedBoardNumber();
            
            // description : 작성자와 입력받은 이메일이 같은지 확인 //
            // boolean equalWriter = boardEntity.getBoardWriterEmail().equals(userEmail);
            // if(!equalWriter) return DeleteBoardResponseDto.noPermission();
            
            // description : 게시물 삭제 //
            boardRepository.delete(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteBoardResponseDto.success();
    }
    
// description : 게시물 조회 //
    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {

        BoardViewEntity boardViewEntity = null;

        try {
            // description : 게시물 번호로 게시글 조회 //
            boardViewEntity = boardViewRepository.findByBoardNumber(boardNumber);

            // description : 존재하는 게시물인지 확인 //
            if(boardViewEntity == null) return GetBoardResponseDto.noExistedBoardNumber();

            // todo : 게시물 조회수 증가 //

            // description : 데이터 베이스에 저장 //
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBoardResponseDto.success(boardViewEntity);
    }

    // description : TOP3 최신순으로 불러오기 // 
    @Override
    public ResponseEntity<? super GetTop3CurrentListResponseDto> getTop3Current() {

        List<BoardListResponseDto> top3Current = null;

        try {
            // description : 최신순으로 상위 3개 게시물 조회 //
            List<BoardViewEntity> boardViewEntities = boardViewRepository.findTop3ByOrderByWriteDatetimeDesc();

            // description : entity를 dto형태로 변환 //
            top3Current = BoardListResponseDto.copyEntityList(boardViewEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTop3CurrentListResponseDto.success(top3Current);

    }

    // description : TOP3 댓글순으로 불러오기 // 
    @Override
    public ResponseEntity<? super GetTop3CommentListResponseDto> getTop3Comment() {
        
        List<BoardListResponseDto> top3Comment = null;

        try {
            List<BoardViewEntity> boardViewEntities = boardViewRepository.findTop3ByOrderByCommentCountDesc();
             top3Comment = BoardListResponseDto.copyEntityList(boardViewEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTop3CommentListResponseDto.successs(top3Comment);
    }

    // description : TOP3 좋아요순으로 불러오기 // 
    @Override
    public ResponseEntity<? super GetTop3FavoriteListResponseDto> getTop3Favorite() {

        List<BoardListResponseDto> top3Favorite = null;

        try {
            List<BoardViewEntity> boardViewEntities = boardViewRepository.findTop3ByOrderByFavoriteCountDesc();
            top3Favorite = BoardListResponseDto.copyEntityList(boardViewEntities);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTop3FavoriteListResponseDto.success(top3Favorite);
    }
// description : 댓글 작성 //
    @Override
    public ResponseEntity<?> postComment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postComment'");
    }

// description : 좋아요 //
    @Override
    public ResponseEntity<?> putFavorite() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putFavorite'");
    }

// description : 특정 유저의 게시물 리스트 조회 //
    @Override
    public ResponseEntity<? super GetUserListResponseDto> getUserBoardList(String writerEmail) {
        
        List<BoardListResponseDto> boardList = null;

        try {
            // description : 특정 이메일에 해당하는 게시물 리스트 조회 //
            List<BoardViewEntity> boardViewEntities = boardViewRepository.findByWriterEmailOrderByWriteDatetimeDesc(writerEmail);
            
            // description : entity를 dto로 변환 //
            boardList = BoardListResponseDto.copyEntityList(boardViewEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserListResponseDto.success(boardList);    
    }

// description : 특정 게시물 댓글 리스트 조회 //
    @Override
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer commentBoardNumber) {

        List<CommentListResponseDto> commentList = null;

        try {
            // description : 게시물의 댓글 리스트 조회 //
            List<CommentListResultSet> resultSets = commentRepository.getCommentList(commentBoardNumber);
            
            // description : resultSet을 dto로 변환 //
            commentList = CommentListResponseDto.copyList(resultSets);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetCommentListResponseDto.success(commentList);


    }

// description : 특정 게시물 좋아요 리스트 조회 //
    @Override
    public ResponseEntity<?> getFavoriteList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFavoriteList'");
    }
// description : 검색 게시물 리스트 조회 //
    @Override
    public ResponseEntity<?> getSearchBoard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchBoard'");
    }

   
    
}
