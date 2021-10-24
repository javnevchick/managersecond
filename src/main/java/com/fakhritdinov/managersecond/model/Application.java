package com.fakhritdinov.managersecond.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "application")
@ToString
public class Application {

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
    private int desiredLoanAmount;
    @Column(name = "approval")
    private boolean approval;
    @Column(name = "loan_maturity")
    private int loanMaturity;
    @Column(name = "approved_loan_amount")
    private int approvedLoanAmount;
    @Column(name = "date_of_approval")
    private java.sql.Date dateOfApproval;
    @Column(name = "client_id")
    private Integer foreignKeyClient;


    public Application() {

    }

    public Application(Client client) {

        name = client.getName();
        passport = client.getPassport();
        maritalStatus = client.getMaritalStatus();
        adress = client.getAdress();
        contactNumber = client.getContactNumber();
        employment = client.getEmployment();
        desiredLoanAmount = client.getDesiredLoanAmount();

        double a = Math.random();
        if(a < 0.5) {
            approval = false;
        } else {
            approval = true;

            while (true) {
                int b = (int)(Math.random() * 365);
                if(b > 30) {
                    loanMaturity = b;
                    break;
                }
            }

            int c = (int)(Math.random() * 10);
            if(c != 0) {
                approvedLoanAmount = desiredLoanAmount / c;
            } else { approvedLoanAmount = desiredLoanAmount; }

            LocalDate date = LocalDate.now();
            dateOfApproval = java.sql.Date.valueOf(date);
        }

        foreignKeyClient = client.getId();
    }

    // Этот конструктор сделан для теста
    public Application(String name, String passport, String maritalStatus, String adress, String
                       contactNumber, String employment, Integer desiredLoanAmount) {
        this.name = name;
        this.passport = passport;
        this.maritalStatus = maritalStatus;
        this.adress = adress;
        this.contactNumber = contactNumber;
        this.employment = employment;
        this.desiredLoanAmount = desiredLoanAmount;

        double a = Math.random();
        if(a < 0.5) {
            this.approval = false;
        } else {
            this.approval = true;

            while (true) {
                int b = (int)(Math.random() * 365);
                if(b > 30) {
                    this.loanMaturity = b;
                    break;
                }
            }

            int c = (int)(Math.random() * 10);
            if(c != 0) {
                this.approvedLoanAmount = this.desiredLoanAmount / c;
            } else { this.approvedLoanAmount = this.desiredLoanAmount; }

            LocalDate date = LocalDate.now();
            this.dateOfApproval = java.sql.Date.valueOf(date);
        }

        this.foreignKeyClient = 500;

    }
}
