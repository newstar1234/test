package com.project.codematchr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.codematchr.entity.BoardViewEntity;

@Repository
public interface BoardViewRepository extends JpaRepository<BoardViewEntity, Integer> {
  
  BoardViewEntity findByBoardNumber(Integer boardNumber);

  List<BoardViewEntity> findTop3ByOrderByWriteDatetimeDesc();

}
