package com.project.codematchr.dto.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.codematchr.common.response.ResponseCode;
import com.project.codematchr.common.response.ResponseMessage;
import com.project.codematchr.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostBoardResponseDto extends ResponseDto {
    
    private PostBoardResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<PostBoardResponseDto> success() {
        PostBoardResponseDto result = new PostBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistedUserEmail() {
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXSITED_USER_EMAIL, ResponseMessage.NO_EXSITED_USER_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
      }
}
