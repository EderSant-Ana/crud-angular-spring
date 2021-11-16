package com.santana.crudspringangular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "First Name may not be null")
	@NotEmpty(message = "First Name may not be null")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "Last Name may not be null")
	@NotEmpty(message = "Last Name may not be null")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "E-mail may not be null")
	@NotEmpty(message = "E-mail may not be null")
	@Email(message = "E-mail is not accepted")
	@Column(name = "email_id")
	private String emailId;
	
	
	

}
