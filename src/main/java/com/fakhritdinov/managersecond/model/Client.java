package com.fakhritdinov.managersecond.model;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
@org.hibernate.annotations.Table(appliesTo = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "passport")
    private String passport;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "adress")
    private String adress;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "employment")
    private String employment;
    @Column(name = "desired_loan_amount")
    private Integer desiredLoanAmount;

}