package com.xcactus.framework.microservice.users.dto;

import com.xcactus.framework.dto.users.dto.AbstractUserDto;

public class UserDto extends AbstractUserDto {
    
	private static final long serialVersionUID = -5309424752869131551L;
	
	private String description;

	public UserDto(Integer id, String firstName, String lastName, String description) {
    	super(id, firstName, lastName);
    	this.description = description;
    }		

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
