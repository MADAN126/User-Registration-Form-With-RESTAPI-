package com.RequestBodyValidation.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RequestBodyValidation.main.DTO.ChangePassword;
import com.RequestBodyValidation.main.DTO.NameDTO;
import com.RequestBodyValidation.main.DTO.UserDTO;
import com.RequestBodyValidation.main.Entity.UserEntity;
import com.RequestBodyValidation.main.ServiceLayer.ServiceLayer;

import jakarta.validation.Valid;

@RestController
public class Controller {

	@Autowired
	ServiceLayer service;

	@PostMapping("/create/user")
	public String create(@Valid @RequestBody UserDTO user) {
		String res = service.createUser(user);
		return res;
	}

//	@GetMapping("/get/user")
//	public List<UserEntity> get() {
//		List<UserEntity> list = service.loadAll();
//		return list;
//	}

	@GetMapping("get/user/path/{city}")
	public List<UserEntity> searchByCity(@PathVariable("city") String country) {
		return service.findByCity();
	}
 
	@GetMapping("/get/user")
	public List<UserEntity> searchByCountry(@RequestParam String country) {
		return service.findByCountry();
	}

	@PutMapping("/user/change/password/{email}")
	public String putMethodName(@PathVariable("email") String email, @RequestBody ChangePassword request) {
		return service.updatePassword(email,request.getPassword());
	}
	
	@PutMapping("/user/change/name")
	public String changeName(@RequestParam String name,@RequestBody NameDTO n1) {
		return service.changeName(name,n1);
	}
	
	
	@DeleteMapping("user/delete/password")
	public String deleteMethodName(@RequestParam String email) {
		return service.deletePassword(email);
	}

}
