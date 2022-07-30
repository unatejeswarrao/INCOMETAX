package com.imginno.incomeTax.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	@Id
    @Column(name = "EMP_ID")
	@NotNull
    private int id;
	@NotBlank(message = "Name is mandatory")
    @Column(name = "FIRST_NAME")
    private String firstName;
	@NotBlank(message = "Last Name is mandatory")
    @Column(name = "LAST_NAME")
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @Column(name = "EMAIL")
    private String email;
    @NotBlank(message = "phone is mandatory")
    @Column(name = "PH_NUM")
    private String contactNo;
    @NotBlank(message = "DOJ is mandatory")
    @Column(name = "DOj")
    private String dob;
    @NotBlank(message = "sal is mandatory")
    @Column(name = "SAL")
    private int SAL;


}
