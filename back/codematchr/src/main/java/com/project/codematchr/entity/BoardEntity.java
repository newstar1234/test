package com.project.codematchr.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.codematchr.dto.request.PatchBoardRequestDto;
import com.project.codematchr.dto.request.PostBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="board")
@Table(name="board")
public class BoardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber; 
    private String boardTitle; 
    private String boardContents;
    private String boardImageUrl;
    private int boardViewCount; 
    private int boardCommentCount; 
    private int boardFavoriteCount; 
    private String boardWriteDatetime; 
    private String boardWriterEmail;

    public BoardEntity(PostBoardRequestDto dto) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.boardTitle = dto.getBoardTitle();
        this.boardContents = dto.getBoardContents();
        this.boardImageUrl = dto.getBoardImageUrl();
        this.boardWriteDatetime = writeDatetime;
    }
    public void patch(PatchBoardRequestDto dto) {
        this.boardTitle = dto.getBoardTitle();
        this.boardContents = dto.getBoardContents();
        this.boardImageUrl = dto.getBoardImageUrl();
    }


}
