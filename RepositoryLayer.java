package com.RequestBodyValidation.main.RepositoryLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.RequestBodyValidation.main.Entity.UserEntity;

import jakarta.transaction.Transactional;

public interface RepositoryLayer extends JpaRepository<UserEntity, String> {

	public List<UserEntity> findByCountry(String string);
	public List<UserEntity> findByCity(String string);
	
	public List<UserEntity> findByName(String string);
}
