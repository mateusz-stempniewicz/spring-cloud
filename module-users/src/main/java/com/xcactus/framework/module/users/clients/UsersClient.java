/**
 * 
 */
package com.xcactus.framework.module.users.clients;

import java.util.ArrayList;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xcactus.framework.module.users.dtos.UserDto;

/**
 * @author mateusz.stempniewicz
 *
 */
@FeignClient("microservice-users")
public interface UsersClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ArrayList<UserDto>> getUsers();
}
