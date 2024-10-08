package org.chintanu.sdjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @Column(name = "COUNTRY_ID")
    private final Long countryId;

    @Column(name = "COUNTRY_ISO_CODE")
    private String countryIsoCode;

    @Column(name = "COUNTRY_NAME")
    private final String countryNm;

    @Column(name = "COUNTRY_SUBREGION")
    private final String countrySubRegion;

    @Column(name = "COUNTRY_SUBREGION_ID")
    private Long countrySubRegionId;

    @Column(name = "COUNTRY_REGION")
    private final String countryRegion;

    @Column(name = "COUNTRY_REGION_ID")
    private Long countryRegionId;

    @Column(name = "COUNTRY_TOTAL")
    private String countryTotal;

    @Column(name = "COUNTRY_TOTAL_ID")
    private Long countryTotalId;

    @Column(name = "COUNTRY_NAME_HIST")
    private String countryNameHist;


}
