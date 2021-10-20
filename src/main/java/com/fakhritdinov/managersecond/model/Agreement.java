package com.fakhritdinov.managersecond.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "agreement")
@org.hibernate.annotations.Table(appliesTo = "agreement")
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "passport")
    private String passport;
    @Column(name = "loan_maturity")
    private int loanMaturity;
    @Column(name = "loan_amount")
    private int loanAmount;
    @Column(name = "date_of_approval")
    private LocalDate dateOfApproval;
    @Column(name = "sign")
    private String sign;
    @Column(name = "date_of_sign")
    private LocalDate dateOfSign;
    @Column(name = "date_of_agreement")
    private LocalDate dateOfAgreement;
    @Column(name = "application_client_idclient")
    private Integer foreignKeyClient;
    @Column(name = "application_idapplication")
    private Integer foreignKeyApplication;

    public Agreement() {

    }

    public Agreement(Application application) {
        name = application.getName();
        passport = application.getPassport();
        loanMaturity = application.getLoanMaturity();
        loanAmount = application.getApprovedLoanAmount();
        dateOfApproval = application.getDateOfApproval();
        dateOfAgreement = LocalDate.now();
        foreignKeyClient = application.getForeignKeyClient();
        foreignKeyApplication = application.getId();
    }
}
