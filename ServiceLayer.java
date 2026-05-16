package com.RequestBodyValidation.main.ServiceLayer;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RequestBodyValidation.main.DTO.NameDTO;
import com.RequestBodyValidation.main.DTO.UserDTO;
import com.RequestBodyValidation.main.Entity.UserEntity;
import com.RequestBodyValidation.main.RepositoryLayer.RepositoryLayer;

@Service
public class ServiceLayer {

	@Autowired
	RepositoryLayer repo;
	
	public String createUser(UserDTO user) {
		UserEntity u1 = new UserEntity();
		u1.setEmailId(user.getEmailId());
		u1.setAge(user.getAge());
		u1.setCity(user.getCity());
		u1.setCountry(user.getCountry());
		u1.setGeneder(user.getGeneder());
		u1.setMobileNumber(user.getMobileNumber());
		u1.setName(user.getName());
		u1.setPassword(user.getPassword());
		u1.setQualification(user.getQualification());
		repo.save(u1);
		return "saved";
	}
	
	public List<UserEntity> loadAll(){
		List<UserEntity> list = repo.findAll();
		return list;
	}
	
	public List<UserEntity> findByCountry() {
		List<UserEntity> list = repo.findByCountry("India");
		return list;
	}
	public List<UserEntity> findByCity() {
		List<UserEntity> list = repo.findByCity("city");
		return list;
	}
	
	public String updatePassword(String email,String password) {
		Optional<UserEntity> user = repo.findById(email);
		if(user.isPresent()) {
			UserEntity u1 = user.get();
			u1.setPassword(password);
			repo.save(u1);
			return "password changed successfully";
		}else {
			return "no user found";
		}
	}

	public String deletePassword(String emailId) {
		Optional<UserEntity> user = repo.findById(emailId);
		if(user.isPresent()) {
			UserEntity u1 = user.get();
			repo.deleteById(emailId);
			return "password deleted successfully";
		}else {
			return "no user found";
		}
	}
	static Scanner sc = new Scanner(System.in);
	//changeName
	public String changeName(String oldName, NameDTO n1) {

	    List<UserEntity> list = repo.findByName(oldName);

	    if(list.isEmpty()) {
	        return "name was not found";
	    }

	    for(UserEntity u1 : list) {

	        u1.setName(n1.getName());

	        repo.save(u1);
	    }

	    return "successfully name was changed";
	}

	
}
