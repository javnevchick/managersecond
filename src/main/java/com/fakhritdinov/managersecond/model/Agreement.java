package com.fakhritdinov.managersecond.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "agreement")
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
    private java.sql.Date dateOfApproval;
    @Column(name = "sign")
    private String sign;
    @Column(name = "date_of_sign")
    private java.sql.Date dateOfSign;
    @Column(name = "date_of_agreement")
    private java.sql.Date dateOfAgreement;
    @Column(name = "application_id")
    private Integer foreignKeyApplication;

    public Agreement() {

    }

    public Agreement(Application application) {
        name = application.getName();
        passport = application.getPassport();
        loanMaturity = application.getLoanMaturity();
        loanAmount = application.getApprovedLoanAmount();
        dateOfApproval = application.getDateOfApproval();

        sign = "Не подписан";

        LocalDate date = LocalDate.now();
        dateOfAgreement = java.sql.Date.valueOf(date);

        foreignKeyApplication = application.getId();
    }

    public void setSign() {
        sign = "Подписан";
        LocalDate date = LocalDate.now();
        dateOfSign = java.sql.Date.valueOf(date);
    }
}
