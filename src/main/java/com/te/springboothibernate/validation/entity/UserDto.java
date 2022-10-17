package com.te.springboothibernate.validation.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserDto {
	@NotNull(message = "name should not be null")
	private String name;

	@Email(message = "should enter valide email address")
	private String email;

	@NotNull
	@Pattern(regexp = "^\\d{10}$",message = "should have at least 10 digits")
	private String mobile;

	private String gender;
	@Min(18)
	@Max(90)
	private int age;

	@NotBlank
	private String nationality;
}
