package com.xcactus.framework.microservice.users;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcactus.framework.microservice.users.dto.UserDto;

@RestController
public class HelloController {
	
	@RequestMapping(value = "/users")
	public ResponseEntity<ArrayList<UserDto>> getUser() {
		ArrayList<UserDto> users = new ArrayList<>();
		users.add(new UserDto(1, "miszcz", "mazzaq", "to jest mistrz mazak"));
		users.add(new UserDto(2, "mateusz", "stempniewicz", "to jest uczeń miszcza mazaka!!!"));
		return new ResponseEntity<ArrayList<UserDto>>(users, HttpStatus.OK);
	}
	
}
