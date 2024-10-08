package org.chintanu.sdjpa.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @Column(name = "CUST_ID")
    private final Long custId;

    @Column(name = "CUST_FIRST_NAME")
    private final String custFirstNm;

    @Column(name = "CUST_LAST_NAME")
    private final String custLastNm;

    @Column(name = "CUST_GENDER")
    private final String custGender;

    @Column(name = "CUST_YEAR_OF_BIRTH")
    private final Integer custYOB;

    @Column(name = "CUST_MARITAL_STATUS")
    private String custMaritalStatus;

    @Column(name = "CUST_STREET_ADDRESS")
    private String custStreetAddress;

    @Column(name = "CUST_POSTAL_CODE")
    private String custPostalCode;

    @Column(name = "CUST_CITY")
    private String custCity;

    @Column(name = "CUST_CITY_ID")
    private Long custCityId;

    @Column(name = "CUST_STATE_PROVINCE")
    private String custStateProvince;

    @Column(name = "CUST_STATE_PROVINCE_ID")
    private Long custStateProvinceId;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    private Country country;

    @Column(name = "CUST_MAIN_PHONE_NUMBER")
    private String custPhnNum;

    @Column(name = "CUST_INCOME_LEVEL")
    private String custIncomeLvl;

    @Column(name = "CUST_CREDIT_LIMIT")
    private Long custCreditLimit;

    @Column(name = "CUST_EMAIL")
    private String custEmail;

    @Column(name = "CUST_TOTAL")
    private String custTotal;

    @Column(name = "CUST_TOTAL_ID")
    private Long custTotalId;

    @Column(name = "CUST_SRC_ID")
    private Long custSrcId;

    @Temporal(TemporalType.DATE)
    @Column(name = "CUST_EFF_FROM")
    private Date custEffFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "CUST_EFF_TO")
    private Date custEffTo;

    @Column(name = "CUST_VALID")
    private String custValid;

}
