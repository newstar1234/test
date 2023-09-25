package com.project.codematchr.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.codematchr.dto.ResponseDto;
import com.project.codematchr.dto.request.PostBoardRequestDto;
import com.project.codematchr.dto.response.BoardListResponseDto;
import com.project.codematchr.dto.response.GetBoardResponseDto;
import com.project.codematchr.dto.response.GetTop3CurrentListResponseDto;
import com.project.codematchr.dto.response.PostBoardResponseDto;
import com.project.codematchr.entity.BoardEntity;
import com.project.codematchr.entity.BoardViewEntity;
import com.project.codematchr.repository.BoardRepository;
import com.project.codematchr.repository.BoardViewRepository;
import com.project.codematchr.repository.UserRepository;
import com.project.codematchr.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {
    
    private final BoardRepository boardRepository;
    private final BoardViewRepository boardViewRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(String userEmail, PostBoardRequestDto dto) {
       
        try {
        // todo : 작성자 이메일이 존재하는지 확인 //
        boolean hasUserEmail = userRepository.existsByUserEmail(userEmail);
        System.out.println(hasUserEmail);
        if(!hasUserEmail) return PostBoardResponseDto.noExistedUserEmail();


        // description : entity 생성 //
        BoardEntity boardEntity = new BoardEntity(userEmail, dto);

        // description : 데이터 베이스에 저장 //
        boardRepository.save(boardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

       return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<?> patchBoard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchBoard'");
    }

    @Override
    public ResponseEntity<?> deleteBoard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }

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

    @Override
    public ResponseEntity<? super GetTop3CurrentListResponseDto> getTop3Current() {

        List<BoardListResponseDto> top3Current = null;

        try {
            
            // description : 최신순으로 상위 3개 게시물 조회 //
            List<BoardViewEntity> boardViewEntities = (List<BoardViewEntity>) boardViewRepository.findTop3ByOrderByWriteDatetimeDesc();

            // description : entity를 dto형태로 변환 //
            top3Current = BoardListResponseDto.copyEntityList(boardViewEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetTop3CurrentListResponseDto.success(top3Current);

    }

   
    
}
