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
public class GetBoardResponseDto extends ResponseDto{
    
    private int boardNumber;
    private String boardTitle;
    private String boardContents;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private String boardWriterEmail;
    private String userNickname;
    private String userProfileImageUrl;

    private GetBoardResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<GetBoardResponseDto> success() {
        GetBoardResponseDto result = new GetBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
