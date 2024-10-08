package org.chintanu.sdjpa.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.chintanu.sdjpa.domain.Country;

import java.util.Date;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CustomerDto {

    private Long custId;
    private String custFirstNm;
    private String custLastNm;
    private String custGender;
    private Integer custYOB;
    private String custMaritalStatus;
    private String custStreetAddress;
    private String custPostalCode;
    private String custCity;
    private Long custCityId;
    private String custStateProvince;
    private Long custStateProvinceId;
    private CountryDto country;
    private String custPhnNum;
    private String custIncomeLvl;
    private Long custCreditLimit;
    private String custEmail;
    private String custTotal;
    private Long custTotalId;
    private Long custSrcId;
    private Date custEffFrom;
    private Date custEffTo;
    private String custValid;

}
