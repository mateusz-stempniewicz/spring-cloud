/**
 * 
 */
package com.xcactus.framework.module.users.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xcactus.framework.module.users.clients.UsersClient;
import com.xcactus.framework.module.users.dtos.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author mateusz.stempniewicz
 *
 */
@Api(tags = "users")
@RequestMapping(value = "/users")
@RestController()
public class UserController {
	
	@Autowired
	private UsersClient userClient;
	
	@ApiOperation("Get users")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<UserDto>> users() {
		
		ResponseEntity<ArrayList<UserDto>> users = userClient.getUsers();
		return users;
	}
}
