package org.chintanu.sdjpa.web.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private Long countryId;
    private String countryIsoCode;
    private String countryNm;
    private String countrySubRegion;
    private Long countrySubRegionId;
    private String countryRegion;
    private Long countryRegionId;
    private String countryTotal;
    private Long countryTotalId;
    private String countryNameHist;
}
