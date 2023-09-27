package com.project.codematchr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.codematchr.entity.FavoriteEntity;
import com.project.codematchr.entity.pk.FavoritePk;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {
  
  

}
