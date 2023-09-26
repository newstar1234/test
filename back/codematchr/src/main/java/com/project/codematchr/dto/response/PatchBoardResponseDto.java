package com.project.codematchr.dto.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.codematchr.common.response.ResponseCode;
import com.project.codematchr.common.response.ResponseMessage;
import com.project.codematchr.dto.ResponseDto;

public class PatchBoardResponseDto extends ResponseDto {
    
    private PatchBoardResponseDto (String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<PatchBoardResponseDto> success() {
        PatchBoardResponseDto result = new PatchBoardResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
