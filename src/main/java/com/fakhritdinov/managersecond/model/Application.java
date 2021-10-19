package com.fakhritdinov.managersecond.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "application")
@org.hibernate.annotations.Table(appliesTo = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private int approvalInt;
    @Column(name = "loan_maturity")
    private int loanMaturity;
    @Column(name = "approved_loan_amount")
    private int approvedLoanAmount;
    @Column(name = "date_of_approval")
    private LocalDate dateOfApproval;


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
            approvalInt = 0;
        } else {
            approvalInt = 1;

            while (true) {
                int b = (int)(Math.random() * 100);
                if(b > 0 && b < 366) {
                    loanMaturity = b;
                    break;
                }
            }

            int c = (int)(Math.random() * 10);
            if(c != 0) {
                approvedLoanAmount = desiredLoanAmount / c;
            } else { approvedLoanAmount = desiredLoanAmount; }

            dateOfApproval = LocalDate.now();
        }
    }
}
