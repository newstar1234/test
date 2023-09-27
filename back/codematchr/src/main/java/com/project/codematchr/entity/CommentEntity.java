package com.project.codematchr.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comment")
@Table(name = "comment")
public class CommentEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int commentNumber;
  private int commentBoardNumber;
  private String commentUserEmail;
  private String commentContents;
  private String commentWriteDatetime;

  public CommentEntity(Integer commentBoardNumber) {
    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String writeDatetime = simpleDateFormat.format(now);

    this.commentBoardNumber = commentBoardNumber;
    this.commentUserEmail = commentUserEmail;
    this.commentContents = commentContents;
    this.commentWriteDatetime = writeDatetime;

  }
  // todo : email과 PostCommentRequestDto 로 작성된 댓글 dto로 받아서 commentContents로 넘겨줘야함 //

}
