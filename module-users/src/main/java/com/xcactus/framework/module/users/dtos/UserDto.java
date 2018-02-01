/**
 * 
 */
package com.xcactus.framework.module.users.dtos;

import com.xcactus.framework.dto.users.dto.AbstractUserDto;

/**
 * @author mateusz.stempniewicz
 *
 */
public class UserDto extends AbstractUserDto {
	
	private static final long serialVersionUID = -5521181643669475046L;
	
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + this.getId() + "; description=" + description + "]";
	}
	
}
