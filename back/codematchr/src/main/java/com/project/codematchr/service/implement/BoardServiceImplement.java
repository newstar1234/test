package com.project.codematchr.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.codematchr.dto.response.GetBoardResponseDto;
import com.project.codematchr.dto.response.PostBoardResponseDto;
import com.project.codematchr.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {@Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard() {
       System.out.println("되나 안되냐");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoard'");
    }

   
    
}
