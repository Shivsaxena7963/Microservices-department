package com.department.departmentMicro.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name="department_name")
    private String departmentName;


    @Column(name = "department_contact_no")
    private String departmentContactNo;


    @Column(name = "department_email_id")
    private String departmentEmail;

}
