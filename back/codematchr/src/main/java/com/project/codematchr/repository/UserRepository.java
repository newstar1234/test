package com.project.codematchr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.codematchr.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

  boolean existsByUserEmail(String userEmail);
  
  @Query(value = 
  "SELECT * " +
  "FROM user " +
  "WHERE user_email IN ( " +
      "SELECT user_email " +
      "FROM favorite " +
      "WHERE favorite_board_number = ?1 " +
    ") ", nativeQuery = true
  ) 
  List<UserEntity> getFavoriteList(Integer boardNumber);

}
