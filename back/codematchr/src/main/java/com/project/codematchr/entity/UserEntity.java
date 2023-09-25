package com.project.codematchr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
@Table(name="user")
public class UserEntity {
  @Id
  String userEmail;
  String userPassword;
  String userNickname;
  String userStateMessage;
  String userTelnumber;
  String userAddress;
  String userAddressDetail;
  String userProfileImageUrl;

}
