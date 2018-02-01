/**
 * 
 */
package com.xcactus.framework.dto.users.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author mateusz.stempniewicz
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractUserDto implements Serializable {

	private static final long serialVersionUID = -4115526263076262281L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	
	public AbstractUserDto() {
		super();
	}
	
	public AbstractUserDto(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AbstractUserDto(Integer id, String firstName, String lastName) {
		this(firstName, lastName);
		this.id = id;
	}
	
	public AbstractUserDto(String firstName, String lastName, String email) {
		this(firstName, lastName);
		this.email = email;
	}
	
	public AbstractUserDto(Integer id, 
			String firstName, 
			String lastName, 
			String email) {
		
		this(id, firstName, lastName);
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbstractUserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}	
}
